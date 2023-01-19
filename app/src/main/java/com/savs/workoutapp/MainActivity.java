package com.savs.workoutapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import Interface.ItemClickListener;

public class MainActivity extends AppCompatActivity {
    TextView exercise;
    ArrayList<Mycard> itemlist;
    private RecyclerView recyclerview;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutmanager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        generateFakeData();
        recyclerview_Config();
    }


    public void generateFakeData() {
        itemlist = new ArrayList<>();
        itemlist.add(new Mycard(R.drawable.one, "Pushups"));
        itemlist.add(new Mycard(R.drawable.two, "crunches"));
        itemlist.add(new Mycard(R.drawable.four, "Lateral side Strech"));
        itemlist.add(new Mycard(R.drawable.six, "Plank"));
        itemlist.add(new Mycard(R.drawable.seven, "Deadlifts"));
    }

    public void recyclerview_Config() {
        //Config for recylcerview
        recyclerview = findViewById(R.id.recyclerview);
        //performance
        recyclerview.setHasFixedSize(true);

        layoutmanager = new LinearLayoutManager(this);
        adapter = new Adapter(itemlist);

        recyclerview.setLayoutManager(layoutmanager);
        recyclerview.setAdapter(adapter);
    }

    public void goto2intent(View v){
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
    }

}