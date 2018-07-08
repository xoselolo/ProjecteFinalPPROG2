package com.example.xosel.projectefinalpprog2.repositories.impl;

import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.xosel.projectefinalpprog2.model.School;
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
import java.util.ArrayList;


public class SchoolsWebService implements SchoolsRepo {
    private static final String URL ="https://testapi-pprog2.azurewebsites.net/api/schools.php?method=getSchools";
    private final RequestQueue requestQueue ;

    public SchoolsWebService(Context context ) {

        this.requestQueue = Volley.newRequestQueue(context);

    }


    public void getSchools(final Callback<ArrayList<School>> dataResponse) {

        StringRequest request =
                new StringRequest(Request.Method.GET, URL,  new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        ArrayList<School> list = null;
                        try {
                            JSONObject json = new JSONObject(response);
                            if(json.getInt("set") == 1) {
                                JSONArray search = json.getJSONArray("msg");

                                list = new ArrayList<>(search.length());
                                for (int i = 0; i < search.length(); i++) {
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
}
