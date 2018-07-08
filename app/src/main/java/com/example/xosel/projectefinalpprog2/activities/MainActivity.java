package com.example.xosel.projectefinalpprog2.activities;

import android.app.ProgressDialog;
import android.support.design.widget.TabLayout;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.xosel.projectefinalpprog2.R;
import com.example.xosel.projectefinalpprog2.adapters.TabAdapter;
import com.example.xosel.projectefinalpprog2.fragments.LlistaEscolesFragment;
import com.example.xosel.projectefinalpprog2.model.School;
import com.example.xosel.projectefinalpprog2.repositories.SchoolsRepo;
import com.example.xosel.projectefinalpprog2.repositories.impl.SchoolsWebService;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {
    private LlistaEscolesFragment tots;
    private LlistaEscolesFragment escoles;
    private LlistaEscolesFragment altres;
    private ArrayList<School> schoolsList;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Spinner spinnerCities;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SchoolsRepo artistasRepo = new SchoolsWebService(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getString(R.string.please_wait));
        progressDialog.show();
        artistasRepo.getSchools( dataListener);

        setContentView(R.layout.activity_main);
        createToolbar();
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
        LlistaEscolesFragment l1 = new LlistaEscolesFragment();
        LlistaEscolesFragment l2 = new LlistaEscolesFragment();
        LlistaEscolesFragment l3 = new LlistaEscolesFragment();
        l1.carrega_dades(schoolsList);
        l2.carrega_dades(schoolsList);
        l3.carrega_dades(schoolsList);
        entries.add(new TabAdapter.TabEntry(l1,getString(R.string.all)));
        entries.add(new TabAdapter.TabEntry(l2, getString(R.string.school)));
        entries.add(new TabAdapter.TabEntry(l3, getString(R.string.other)));

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
    private SchoolsRepo.Callback<ArrayList<School>> dataListener = new SchoolsRepo.Callback<ArrayList<School>>() {
        @Override
        public void onResponse(ArrayList<School> schoolList_aux) {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
            schoolsList = schoolList_aux;
            createTabs();
            //adapter.updateData(artistaList_aux);
        }
    };
}
