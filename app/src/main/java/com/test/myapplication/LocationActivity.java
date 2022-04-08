package com.test.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.test.myapplication.model.UserModel;

import java.util.ArrayList;

public class LocationActivity extends AppCompatActivity {
    DBHandler dbHandler;
    ArrayList<UserModel> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
         dbHandler = new DBHandler(this);



         dbHandler.addNew("123","123","123");

        data = dbHandler.getDatalist();

        Log.d("asd",dbHandler.getDatalist().get(0).getLat());
        RecyclerView rvlocation = findViewById(R.id.rv_location);

        rvlocation.setLayoutManager(new LinearLayoutManager(this));

        LocationAdapter adpter = new LocationAdapter(data);
        rvlocation.setAdapter(adpter);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                dbHandler.addNew("lat","long", String.valueOf(System.currentTimeMillis()));
                data = dbHandler.getDatalist();
                adpter.notifyDataSetChanged();

                handler.postDelayed(this, 3000);
            }
        }, 3000);
    }
}