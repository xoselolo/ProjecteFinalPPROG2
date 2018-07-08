package com.example.xosel.projectefinalpprog2.activities;

import android.support.design.widget.TabLayout;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.xosel.projectefinalpprog2.R;
import com.example.xosel.projectefinalpprog2.adapters.TabAdapter;
import com.example.xosel.projectefinalpprog2.fragments.LlistaEscolesFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Spinner spinnerCities;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createToolbar();
        createTabs();
        createSpinner();


    }

    private void createToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void createTabs() {
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        ArrayList<TabAdapter.TabEntry> entries = new ArrayList<>();
        entries.add(new TabAdapter.TabEntry(new LlistaEscolesFragment(), getString(R.string.all)));
        entries.add(new TabAdapter.TabEntry(new LlistaEscolesFragment(), getString(R.string.school)));
        entries.add(new TabAdapter.TabEntry(new LlistaEscolesFragment(), getString(R.string.other)));

        TabAdapter adapter = new TabAdapter(getSupportFragmentManager(), entries);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main_activity, menu);
        return true;
    }
    public void createSpinner(){
        spinnerCities = (Spinner) findViewById(R.id.spinner);
        String[] cities = new String[]{getString(R.string.barcelona),getString(R.string.girona),getString(R.string.lleida),getString(R.string.tarragona)};
        ArrayAdapter<String> adaptador_cities = new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_item, cities);
        adaptador_cities.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCities.setAdapter(adaptador_cities);

    }
}
