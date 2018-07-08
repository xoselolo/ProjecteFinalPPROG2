package com.example.xosel.projectefinalpprog2.repositories;

import android.os.Bundle;

import com.example.xosel.projectefinalpprog2.model.School;

import java.util.ArrayList;
import java.util.List;

public interface SchoolsRepo {
    interface Callback<Response> {
        void onResponse(Response response);
    }
    void getSchools( final Callback<ArrayList<School>> dataResponse );
}
