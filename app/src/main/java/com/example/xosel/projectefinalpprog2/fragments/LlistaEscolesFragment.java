package com.example.xosel.projectefinalpprog2.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.xosel.projectefinalpprog2.R;
import com.example.xosel.projectefinalpprog2.adapters.TouchableListViewAdapter;
import com.example.xosel.projectefinalpprog2.model.School;

import java.util.ArrayList;

public class LlistaEscolesFragment extends Fragment {

    private ListView listView;
    private ArrayList<School> citySchools;
    private ArrayList<School> typeSchools;
    private TouchableListViewAdapter adapter;
    private ArrayList<String> ciutatsSpinner;
    private Context context;
    private int currentType; //1 Totes, 2 Escoles, 3 Altres
    private int currentCity; //1 Barcelona, 2 Girona, 3 Lleida, 4 Tarragona

    public LlistaEscolesFragment() {
        typeSchools = new ArrayList<School>();
        ciutatsSpinner = new ArrayList<String>();
        currentType = 1;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_schools, container, false);

        ListView listView = view.findViewById(R.id.escoles_listview);

        adapter = new TouchableListViewAdapter(typeSchools, listView, getActivity(), null);

        return view;
    }
}
