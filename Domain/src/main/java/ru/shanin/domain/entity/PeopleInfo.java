package ru.shanin.domain.entity;

import androidx.annotation.NonNull;

import com.google.gson.Gson;

import java.util.ArrayList;

public class PeopleInfo {

    private final String lastName;
    private final String firstName;
    private final String secondName;
    private final int age;
    private final String email;
    private final String phone;
    private final ArrayList<String> listOfKnowledge;
    private final String pathToPhoto;

    // Constructor for exist "room's database entity"
    public PeopleInfo(
            String lastName,
            String firstName,
            String secondName,
            int age,
            String email,
            String phone,
            String pathToPhoto,
            ArrayList<String> listOfKnowledge
    ) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.pathToPhoto = pathToPhoto;
        this.listOfKnowledge = listOfKnowledge;
    }

    // Constructor by default for new objects
    public PeopleInfo(
            String lastName,
            String firstName,
            String secondName,
            // int age;
            String email,
            String phone,
            String pathToPhoto,
            ArrayList<String> listOfKnowledge
    ) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.secondName = secondName;
        // this.age = age;
        this.age = (int) (Math.random() * 61 + 5);
        this.email = email;
        this.phone = phone;
        this.pathToPhoto = pathToPhoto;
        this.listOfKnowledge = listOfKnowledge;
    }

    @NonNull
    @Override
    public String toString() {
        return lastName + ", " + firstName + " " + secondName;
    }

    private String createSHA256String() {
        return lastName + firstName + secondName + age +
                email + phone +
                (new Gson()).toJson(listOfKnowledge);
    }

    public String getToSHA256() {
        return createSHA256String();
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public ArrayList<String> getListOfKnowledge() {
        return listOfKnowledge;
    }

    public String getPathToPhoto() {
        return pathToPhoto;
    }

}








