package com.test.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.test.myapplication.model.DataClass;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.rv_recycler);
        Button btn = findViewById(R.id.button);


        context = this;
        String  jsonString =loadJSONFromAsset(this); //http request
        DataClass data;
        Gson gson = new Gson();
        data= gson.fromJson(jsonString,DataClass.class);
        Log.e("asd",data.get(0).getId());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new MyListAdapter(data));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,LocationActivity.class);
                startActivity(intent);

            }
        });


    }

    public String loadJSONFromAsset( Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("EXMP.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}