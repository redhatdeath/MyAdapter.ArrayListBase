package ru.shanin.app;

import android.app.Application;
import android.util.Log;

import ru.shanin.data.repositoryImpl.PeopleArrayListRepositoryImpl;
import ru.shanin.domain.repository.PeopleDomainRepository;
import ru.shanin.domain.usecases.PeopleAddNewUseCases;
import ru.shanin.domain.usecases.PeopleDeleteByIdUseCase;
import ru.shanin.domain.usecases.PeopleGetByAllUseCase;
import ru.shanin.domain.usecases.PeopleGetByIdUseCase;

public class AppStart extends Application {

    private PeopleDomainRepository impl;
    private PeopleGetByIdUseCase getById;
    private PeopleAddNewUseCases addNew;
    private PeopleDeleteByIdUseCase delete;
    private PeopleGetByAllUseCase getAll;

    public PeopleGetByIdUseCase getGetById() {
        return getById;
    }

    public PeopleAddNewUseCases getAddNew() {
        return addNew;
    }

    public PeopleDeleteByIdUseCase getDelete() {
        return delete;
    }

    public PeopleGetByAllUseCase getGetAll() {
        return getAll;
    }

    private static AppStart instance;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.w("AppStart", "AppStart is work!@!");
        instance = this;
        impl = setupImpl();
        setupUseCases(impl);
    }

    private PeopleDomainRepository setupImpl() {
        // work with local database records
        // AppDatabase database = AppDatabase.getInstance(this);
        // return new PeopleRoomRepositoryImpl(database.roomPeopleDao());

        // work with temp records
        return new PeopleArrayListRepositoryImpl();
    }

    private void setupUseCases(PeopleDomainRepository impl) {
        getById = new PeopleGetByIdUseCase(impl);
        addNew = new PeopleAddNewUseCases(impl);
        delete = new PeopleDeleteByIdUseCase(impl);
        getAll = new PeopleGetByAllUseCase(impl);
    }


    public static AppStart getInstance() {
        return instance;
    }
}
