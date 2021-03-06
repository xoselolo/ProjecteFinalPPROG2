package com.example.xosel.projectefinalpprog2.activities;

import android.app.ProgressDialog;
import android.support.design.widget.TabLayout;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.xosel.projectefinalpprog2.R;
import com.example.xosel.projectefinalpprog2.adapters.SpinnerAdapter;
import com.example.xosel.projectefinalpprog2.adapters.TabAdapter;
import com.example.xosel.projectefinalpprog2.fragments.LlistaEscolesFragment;
import com.example.xosel.projectefinalpprog2.model.School;
import com.example.xosel.projectefinalpprog2.model.SchoolType;
import com.example.xosel.projectefinalpprog2.repositories.SchoolsRepo;
import com.example.xosel.projectefinalpprog2.repositories.impl.SchoolsWebService;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {
    private LlistaEscolesFragment tots;
    private LlistaEscolesFragment escoles;
    private LlistaEscolesFragment altres;
    private ArrayList<School> all_schools_array;
    private ArrayList<School> school_schools_array;
    private ArrayList<School> other_schools_array;
    private ProgressDialog progressDialog;
    private TabAdapter tabAdapter ;
    private int spinner_selection = 0;
    private Spinner spinnerCities;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createToolbar();
        if(savedInstanceState == null){
            SchoolsRepo artistasRepo = new SchoolsWebService(this);
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage(getString(R.string.please_wait));
            progressDialog.show();
            artistasRepo.getSchools(dataListener);

        }else{
            dataListener = null;
        }


    }

    private void createToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void createTabs() {
         TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
         ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        ArrayList<TabAdapter.TabEntry> entries = new ArrayList<>();
        tots = new LlistaEscolesFragment();
        escoles = new LlistaEscolesFragment();
        altres = new LlistaEscolesFragment();

        ArrayList<School> all_schools_array_filtered = new ArrayList<School>();
        ArrayList<School> school_schools_array_filtered = new ArrayList<School>();
        ArrayList<School> other_schools_array_filtered = new ArrayList<School>();


        entries.add(new TabAdapter.TabEntry(tots,getString(R.string.all)));
        entries.add(new TabAdapter.TabEntry(escoles, getString(R.string.school)));
        entries.add(new TabAdapter.TabEntry(altres, getString(R.string.other)));

        tabAdapter = new TabAdapter(getSupportFragmentManager(), entries);
        viewPager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(viewPager);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main_activity, menu);
        return true;
    }


    public void createSpinner(){
        spinnerCities =  findViewById(R.id.spinner);
        String[] cities = new String[]{getString(R.string.barcelona),getString(R.string.girona),getString(R.string.lleida),getString(R.string.tarragona)};

        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(tots,escoles,altres,all_schools_array, school_schools_array, other_schools_array, tabAdapter);
        ArrayAdapter<String> adaptador_cities = new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_item, cities);


        adaptador_cities.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCities.setAdapter(adaptador_cities);
        spinnerCities.setOnItemSelectedListener(spinnerAdapter);
    }

    private SchoolsRepo.Callback<ArrayList<School>> dataListener = new SchoolsRepo.Callback<ArrayList<School>>() {
        @Override
        public void onResponse(ArrayList<School> schoolList_aux) {
            all_schools_array = schoolList_aux;
            separaSchoolOthers();
            createTabs();
            createSpinner();
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }

        }
    };
    private void separaSchoolOthers(){
        school_schools_array = new ArrayList<School>();
        other_schools_array = new ArrayList<School>();
        for(School aux: all_schools_array){
            SchoolType type = aux.getType();
            if(type.isInfantil() || type.isPrimaria() || type.isEso()){
                school_schools_array.add(aux);
            }
            if(type.isBatxillerat() || type.isFP() || type.isUniversitat()){
                other_schools_array.add(aux);

            }
        }
    }
   /* @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("SPINNER",spinner_selection);
        outState.putSerializable("ALL_SCHOOLS",all_schools_array);

        super.onSaveInstanceState(outState);


    } @Override

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            all_schools_array = (ArrayList<School>) savedInstanceState.getSerializable("ALL_SCHOOLS");
            spinner_selection = savedInstanceState.getInt("SPINNER");
            separaSchoolOthers();
            createTabs();
            createSpinner();
        }
        super.onRestoreInstanceState(savedInstanceState);
    }*/



}


