package ru.shanin.myadapter.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import ru.shanin.myadapter.R;
import ru.shanin.myadapter.fragments.list_of_people.ListOfPeople;


public class Activity_Main extends AppCompatActivity {
    private FragmentContainerView fragmentAboutPeople = null;
    private FragmentContainerView fragmentListOfPeople = null;
    private Boolean isOnePane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragments();
        startFragmentListOfPeople(isOnePane);
    }

    private void initFragments() {
        fragmentAboutPeople = findViewById(R.id.container_about_people);
        fragmentListOfPeople = findViewById(R.id.container_list_of_people);
        isOnePane = isOnePaneMode();
    }

    private boolean isOnePaneMode() {
        return fragmentAboutPeople == null;
    }

    private void startFragmentListOfPeople(Boolean isOnePane) {
        Fragment fragment = ListOfPeople.newInstance(isOnePane);
        getSupportFragmentManager()
                .popBackStack();
        getSupportFragmentManager()
                .beginTransaction()
                .add(
                        R.id.container_list_of_people,
                        fragment
                )
                .commit();
    }
}