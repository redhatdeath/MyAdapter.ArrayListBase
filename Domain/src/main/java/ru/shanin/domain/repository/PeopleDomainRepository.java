package ru.shanin.domain.repository;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

import ru.shanin.domain.entity.People;

public interface PeopleDomainRepository {

    void peopleAddNew(People people);

    void peopleEditById(People people);

    void peopleDeleteById(People people);

    MutableLiveData<ArrayList<People>> peopleGetAll();

    MutableLiveData<People> peopleGetById(String _id);

}
