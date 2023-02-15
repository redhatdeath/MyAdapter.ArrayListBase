package ru.shanin.myadapter.fragments.list_of_people;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import ru.shanin.domain.entity.People;


public class DiffCallback extends DiffUtil.ItemCallback<People> {

    @Override
    public boolean areItemsTheSame(@NonNull People oldPeople, @NonNull People newPeople) {
        return (oldPeople.get_id()) == (newPeople.get_id());
    }

    @Override
    public boolean areContentsTheSame(@NonNull People oldPeople, @NonNull People newPeople) {
        return oldPeople.equals(newPeople);
    }
}
