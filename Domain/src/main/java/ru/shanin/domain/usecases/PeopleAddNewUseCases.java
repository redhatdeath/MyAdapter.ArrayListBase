package ru.shanin.domain.usecases;


import ru.shanin.domain.entity.People;
import ru.shanin.domain.repository.PeopleDomainRepository;

public class PeopleAddNewUseCases {
    private final PeopleDomainRepository repository;

    public PeopleAddNewUseCases(PeopleDomainRepository repository) {
        this.repository = repository;
    }

    public void peopleAddNew(People people) {
        repository.peopleAddNew(people);
    }
}
