package ru.shanin.domain.usecases;


import ru.shanin.domain.entity.People;
import ru.shanin.domain.repository.PeopleDomainRepository;

public class PeopleEditByIdUseCase {
    private PeopleDomainRepository repository;

    public PeopleEditByIdUseCase(PeopleDomainRepository repository) {
        this.repository = repository;
    }

    public void peopleEditById(People people) {
        repository.peopleEditById(people);
    }

}
