package com.example.xosel.projectefinalpprog2.activities;

import android.support.design.widget.TabLayout;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TableLayout;

import com.example.xosel.projectefinalpprog2.R;
import com.example.xosel.projectefinalpprog2.adapters.TabAdapter;
import com.example.xosel.projectefinalpprog2.fragments.LlistaEscolesFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Fiquem la Toolbar
        createToolbar();
        createTabs();

        //Hola
    }



    private void createToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void createTabs() {
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        ArrayList<TabAdapter.TabEntry> entries = new ArrayList<>();
        entries.add(new TabAdapter.TabEntry(new LlistaEscolesFragment(), "All"));
        entries.add(new TabAdapter.TabEntry(new LlistaEscolesFragment(), "School"));
        entries.add(new TabAdapter.TabEntry(new LlistaEscolesFragment(), "Other"));

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
}
