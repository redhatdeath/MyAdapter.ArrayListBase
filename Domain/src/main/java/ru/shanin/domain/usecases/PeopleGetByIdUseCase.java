package ru.shanin.domain.usecases;

import androidx.lifecycle.MutableLiveData;

import ru.shanin.domain.entity.People;
import ru.shanin.domain.repository.PeopleDomainRepository;

public class PeopleGetByIdUseCase {

    private final PeopleDomainRepository repository;

    public PeopleGetByIdUseCase(PeopleDomainRepository repository) {
        this.repository = repository;
    }

    public MutableLiveData<People> peopleGetById(String _id) {
        return repository.peopleGetById(_id);
    }
}