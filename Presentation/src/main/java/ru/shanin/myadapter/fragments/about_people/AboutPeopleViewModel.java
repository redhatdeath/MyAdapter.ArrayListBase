package ru.shanin.myadapter.fragments.about_people;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ru.shanin.domain.entity.People;
import ru.shanin.domain.usecases.PeopleGetByIdUseCase;


public class AboutPeopleViewModel extends ViewModel {

    private MutableLiveData<People> peopleLiveData;

    private PeopleGetByIdUseCase getById;

    public AboutPeopleViewModel(PeopleGetByIdUseCase getById) {
        this.getById = getById;
    }

    protected MutableLiveData<People> getPeople(String peopleId) {
        peopleLiveData = getById.peopleGetById(peopleId);
        return peopleLiveData;
    }


}

