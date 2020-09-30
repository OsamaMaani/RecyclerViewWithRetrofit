package com.example.retrofitwithrecyclerview;

import
        androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.retrofitwithrecyclerview.adapters.RecyclerViewAdapter;
import com.example.retrofitwithrecyclerview.models.Post;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView  rv;
    private List<Post> data;
    RecyclerViewAdapter recyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Error", "onCreate: Start Good");

        rv = findViewById(R.id.rv);
        //rv.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,
                RecyclerView.VERTICAL, false);
        rv.setLayoutManager(layoutManager);

        Log.d("Error", "onCreate: Before ArrayList");

        data = new ArrayList<>();
        data.add(new Post(1,"oo ", "kkk"));
        data.add(new Post(1,"oo ", "kkk"));
        data.add(new Post(1,"oo ", "kkk"));
        data.add(new Post(1,"oo ", "kkk"));
        data.add(new Post(1,"oo ", "kkk"));
        data.add(new Post(1,"oo ", "kkk"));
        data.add(new Post(1,"oo ", "kkk"));

        Log.d("Error", "onCreate: Before ArrayAdapter");
        recyclerViewAdapter = new RecyclerViewAdapter(data);
        Log.d("Error", "onCreate: ArrayAdapter init");
        rv.setAdapter(recyclerViewAdapter);
        Log.d("Error", "onCreate: ArrayAdapter setting adapter");

    }
}