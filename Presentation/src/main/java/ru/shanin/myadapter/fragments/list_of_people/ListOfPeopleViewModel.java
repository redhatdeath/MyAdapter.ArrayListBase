package ru.shanin.myadapter.fragments.list_of_people;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import ru.shanin.domain.entity.People;
import ru.shanin.domain.usecases.PeopleAddNewUseCases;
import ru.shanin.domain.usecases.PeopleDeleteByIdUseCase;
import ru.shanin.domain.usecases.PeopleGetByAllUseCase;

public class ListOfPeopleViewModel extends ViewModel {
    private MutableLiveData<ArrayList<People>> peoplesListLiveData;

    private PeopleDeleteByIdUseCase delete;
    private PeopleAddNewUseCases addNew;
    private PeopleGetByAllUseCase getAll;

    public ListOfPeopleViewModel(
            PeopleDeleteByIdUseCase delete,
            PeopleAddNewUseCases addNew,
            PeopleGetByAllUseCase getAll
    ) {
        this.delete = delete;
        this.addNew = addNew;
        this.getAll = getAll;
    }

    protected MutableLiveData<ArrayList<People>> getPeopleList() {
        peoplesListLiveData = getAll.peopleGetByAll();
        return peoplesListLiveData;
    }

    protected void addNewPeople(People people) {
        addNew.peopleAddNew(people);
    }

    protected void deletePeople(People people) {
        delete.peopleDeleteById(people);
    }
}