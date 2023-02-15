package ru.shanin.domain.usecases;


import ru.shanin.domain.entity.People;
import ru.shanin.domain.repository.PeopleDomainRepository;

public class PeopleDeleteByIdUseCase {
    private PeopleDomainRepository repository;

    public PeopleDeleteByIdUseCase(PeopleDomainRepository repository) {
        this.repository = repository;
    }

    public void peopleDeleteById(People people) {
        repository.peopleDeleteById(people);
    }

}
