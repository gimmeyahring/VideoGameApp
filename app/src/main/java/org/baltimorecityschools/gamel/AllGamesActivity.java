package org.baltimorecityschools.gamel;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllGamesActivity extends AppCompatActivity {

    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_games);
        recyclerView = findViewById(R.id.recyclerView);
        Allgames.loadallgames(this);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));






        MyAdapter adapter = new MyAdapter(Allgames.allgames);

        recyclerView.setAdapter(adapter);



    }
}