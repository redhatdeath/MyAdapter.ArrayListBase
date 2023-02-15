package ru.shanin.data.repositoryImpl;


import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

import ru.shanin.domain.entity.People;
import ru.shanin.domain.repository.PeopleDomainRepository;

public class PeopleArrayListRepositoryImpl implements PeopleDomainRepository {

    private final MutableLiveData<ArrayList<People>> dataLiveData;
    private final MutableLiveData<People> peopleLiveData;
    private final ArrayList<People> data;

    {
        data = new ArrayList<>();
        dataLiveData = new MutableLiveData<>();
        peopleLiveData = new MutableLiveData<>();
    }


    @Override
    public void peopleAddNew(People people) {
        data.add(people);
        data.sort(People.byID);
        updateList();
    }

    private void updateList() {
        dataLiveData.postValue(new ArrayList<>(data));
    }

    @Override
    public void peopleEditById(People people) {
        peopleDeleteById(findByIdInData(people.get_id()));
        peopleAddNew(new People(people.getPeopleInfo()));
    }

    @Override
    public void peopleDeleteById(People people) {
        data.remove(people);
        updateList();
    }

    @Override
    public MutableLiveData<ArrayList<People>> peopleGetAll() {
        return dataLiveData;
    }

    @Override
    public MutableLiveData<People> peopleGetById(String _id) {
        People people = findByIdInData(_id);
        if (people != null) {
            peopleLiveData.postValue(people);
            return peopleLiveData;
        } else throw new RuntimeException("There is no element with id = " + _id);
    }

    private People findByIdInData(String id) {
        for (People p : data)
            if (p.get_id().equals(id))
                return p;
        return null;
    }
}
