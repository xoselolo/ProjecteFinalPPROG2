package com.example.xosel.projectefinalpprog2.repositories.impl;

import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.example.xosel.projectefinalpprog2.model.School;
import com.example.xosel.projectefinalpprog2.model.SchoolType;
import com.example.xosel.projectefinalpprog2.repositories.SchoolsRepo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;


public class SchoolsWebService implements SchoolsRepo {
    private static final String URL ="https://testapi-pprog2.azurewebsites.net/api/schools.php?method=getSchools";
    private static final String RES ="res";
    private static final String MSG ="msg";
    private static final String SCHOOL_ID ="id";
    private static final String SCHOOL_NAME ="schoolName";
    private static final String SCHOOL_ADDRESS ="schoolAddress";
    private static final String INFANTIL ="isInfantil";
    private static final String PRIMARIA ="isPrimaria";
    private static final String ESO ="isEso";
    private static final String BAT ="isBatxillerat";
    private static final String FP ="isFP";
    private static final String UNI ="isUniversitat";
    private static final String SCHOOL_DESCRIPTION ="description";
    private static final String SCHOOL_PROVINCE ="province";

    private final RequestQueue requestQueue ;

    public SchoolsWebService(Context context ) {

        this.requestQueue = Volley.newRequestQueue(context);

    }


    public void getSchools(final Callback<ArrayList<School>> dataResponse) {

        JSONObject jsonRequest = new JSONObject();
        JsonObjectRequest request =
                new JsonObjectRequest( URL, jsonRequest,  new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(final JSONObject response) {
                        ArrayList<School> list = null;
                        try {
                            if(response.getInt(RES) == 1) {
                                JSONArray search = response.getJSONArray(MSG);

                                list = new ArrayList<>(search.length());
                                for (int i = 0; i < search.length(); i++) {
                                   list.add(createSchoolType(search.getJSONObject(i)));
                                }


                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        dataResponse.onResponse(list);
                    }
                }, null);
        requestQueue.add(request);
    }
    private School createSchoolType(JSONObject object) throws JSONException {
        SchoolType type = new SchoolType();
        type.setInfantil(string_to_boolean(object.getString(INFANTIL)));
        type.setPrimaria(string_to_boolean(object.getString(PRIMARIA)));
        type.setEso(string_to_boolean(object.getString(ESO)));
        type.setBatxillerat(string_to_boolean(object.getString(BAT)));
        type.setFP(string_to_boolean(object.getString(FP)));
        type.setUniversitat(string_to_boolean(object.getString(UNI)));
        return   new School(Integer.parseInt(object.getString(SCHOOL_ID)),
                object.getString(SCHOOL_NAME),
                object.getString(SCHOOL_ADDRESS),
                object.getString(SCHOOL_DESCRIPTION),
                type,
                object.getString(SCHOOL_PROVINCE));

    }
    private Boolean string_to_boolean(String aux){
        return aux.equals("1");
    }
}

