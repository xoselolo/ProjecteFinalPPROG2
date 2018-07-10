package com.example.xosel.projectefinalpprog2.adapters;

import android.content.Context;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.xosel.projectefinalpprog2.R;
import com.example.xosel.projectefinalpprog2.model.School;

import java.util.ArrayList;
import java.util.List;

public class TouchableListViewAdapter extends BaseAdapter implements View.OnTouchListener {
    //Attributes
    private ArrayList<School> data;
    private Context context;
    private GestureDetector gestureDetector;
    private String actualActivity;

    //Constructor
    public TouchableListViewAdapter(ArrayList<School> data , Context context, String actualActivity) {
        this.data = data;
        this.context = context;
        this.gestureDetector = new GestureDetector(context, new GestureDetector.OnGestureListener() {

            @Override
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override
            public void onShowPress(MotionEvent motionEvent) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {

            }

            @Override
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
                return false;
            }
        });
        this.actualActivity = actualActivity;
    }

    //Getters & Setters
    public ArrayList<School> getData() {
        return data;
    }

    public void setData(ArrayList<School> data) {
        this.data = data;
    }


    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public GestureDetector getGestureDetector() {
        return gestureDetector;
    }

    public void setGestureDetector(GestureDetector gestureDetector) {
        this.gestureDetector = gestureDetector;
    }

    public String getActualActivity() {
        return actualActivity;
    }

    public void setActualActivity(String actualActivity) {
        this.actualActivity = actualActivity;
    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return gestureDetector.onTouchEvent(motionEvent);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return data.get(i).hashCode();
    }

    @Override
    public View getView(int i, View itemView, ViewGroup viewGroup) {
        View view;
        if ( itemView == null) {
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.school_item,
                    viewGroup, false);
        } else {
            view = itemView;
        }

        School school = data.get(i);

        TextView schoolName = (TextView) view.findViewById(R.id.item_school_name_textview);
        schoolName.setText(school.getName());

        TextView schoolAddress = (TextView) view.findViewById(R.id.item_school_adress_textview);
        schoolAddress.setText(school.getAdress());

        ImageView imageView = (ImageView) view.findViewById(R.id.item_school_imageview);
        imageView.setImageResource(R.drawable.image);

        return view;
    }


}
