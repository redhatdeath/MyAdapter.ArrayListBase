package ru.shanin.domain.entity.comparators;


import java.util.Comparator;

import ru.shanin.domain.entity.People;

public class ComparatorByID implements Comparator<People> {

    @Override
    public int compare(People people1, People people2) {
        String id1 = people1.get_id();
        String id2 = people2.get_id();
        return id1.compareTo(id2);
    }
}