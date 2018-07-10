package com.example.xosel.projectefinalpprog2.adapters;

import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.example.xosel.projectefinalpprog2.fragments.LlistaEscolesFragment;
import com.example.xosel.projectefinalpprog2.model.School;

import java.util.ArrayList;

public class SpinnerAdapter implements AdapterView.OnItemSelectedListener{

    private LlistaEscolesFragment tots;
    private LlistaEscolesFragment escoles;
    private LlistaEscolesFragment altres;

    private FragmentStatePagerAdapter tabAdapter;


    private ArrayList<School> all_schools_array;
    private ArrayList<School> school_schools_array;
    private ArrayList<School> other_schools_array;

    public SpinnerAdapter(LlistaEscolesFragment tots, LlistaEscolesFragment escoles,
                          LlistaEscolesFragment altres,
                          ArrayList<School> all_schools_array,
                          ArrayList<School> school_schools_array,
                          ArrayList<School> other_schools_array,
                          FragmentStatePagerAdapter tabAdapter) {
        this.tots = tots;
        this.escoles = escoles;
        this.altres = altres;
        this.all_schools_array = all_schools_array;
        this.school_schools_array = school_schools_array;
        this.other_schools_array = other_schools_array;
        this.tabAdapter = tabAdapter;

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(all_schools_array == null || tots == null || escoles == null || altres == null) {
            return;
        }
        ArrayList<School> all_schools_array_filtered = new ArrayList<School>();
        ArrayList<School> school_schools_array_filtered = new ArrayList<School>();
        ArrayList<School> other_schools_array_filtered = new ArrayList<School>();
        switch (position) {
            case 0:
                for(School auxSchool: all_schools_array){
                    if (auxSchool.getProvince().equals("barcelona")){
                        all_schools_array_filtered.add(auxSchool);
                    }

                }
                for(School auxSchool: school_schools_array){
                    if (auxSchool.getProvince().equals("barcelona")){
                        school_schools_array_filtered.add(auxSchool);
                    }

                }
                for(School auxSchool: other_schools_array) {
                    if (auxSchool.getProvince().equals("barcelona")) {
                        other_schools_array_filtered.add(auxSchool);
                    }
                }
                tots.carrega_dades(all_schools_array_filtered);
                escoles.carrega_dades(school_schools_array_filtered);
                altres.carrega_dades(other_schools_array_filtered);
                tabAdapter.notifyDataSetChanged();


                break;
            case 1:
                for(School auxSchool: all_schools_array){
                    if (auxSchool.getProvince().equals("girona")){
                        all_schools_array_filtered.add(auxSchool);
                    }

                }
                for(School auxSchool: school_schools_array){
                    if (auxSchool.getProvince().equals("girona")){
                        school_schools_array_filtered.add(auxSchool);
                    }

                }
                for(School auxSchool: other_schools_array) {
                    if (auxSchool.getProvince().equals("girona")) {
                        other_schools_array_filtered.add(auxSchool);
                    }
                }
                tots.carrega_dades(all_schools_array_filtered);
                escoles.carrega_dades(school_schools_array_filtered);
                altres.carrega_dades(other_schools_array_filtered);
                tabAdapter.notifyDataSetChanged();
                break;
            case 2:
                for(School auxSchool: all_schools_array){
                    if (auxSchool.getProvince().equals("lleida")){
                        all_schools_array_filtered.add(auxSchool);
                    }

                }
                for(School auxSchool: school_schools_array){
                    if (auxSchool.getProvince().equals("lleida")){
                        school_schools_array_filtered.add(auxSchool);
                    }

                }
                for(School auxSchool: other_schools_array) {
                    if (auxSchool.getProvince().equals("lleida")) {
                        other_schools_array_filtered.add(auxSchool);
                    }
                }
                tots.carrega_dades(all_schools_array_filtered);
                escoles.carrega_dades(school_schools_array_filtered);
                altres.carrega_dades(other_schools_array_filtered);
                tabAdapter.notifyDataSetChanged();
                break;
            case 3:
                for(School auxSchool: all_schools_array){
                    if (auxSchool.getProvince().equals("tarragona")){
                        all_schools_array_filtered.add(auxSchool);
                    }

                }
                for(School auxSchool: school_schools_array){
                    if (auxSchool.getProvince().equals("tarragona")){
                        school_schools_array_filtered.add(auxSchool);
                    }

                }
                for(School auxSchool: other_schools_array) {
                    if (auxSchool.getProvince().equals("tarragona")) {
                        other_schools_array_filtered.add(auxSchool);
                    }
                }
                tots.carrega_dades(all_schools_array_filtered);
                escoles.carrega_dades(school_schools_array_filtered);
                altres.carrega_dades(other_schools_array_filtered);
                tabAdapter.notifyDataSetChanged();
                break;
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
