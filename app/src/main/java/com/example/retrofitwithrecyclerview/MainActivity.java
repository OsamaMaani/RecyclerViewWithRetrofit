package com.example.retrofitwithrecyclerview;

import
        androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.retrofitwithrecyclerview.adapters.RecyclerViewAdapter;
import com.example.retrofitwithrecyclerview.models.ApiInterface;
import com.example.retrofitwithrecyclerview.models.Post;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

         Retrofit retrofit = new Retrofit.Builder()
                 .baseUrl("https://jsonplaceholder.typicode.com/")
                 .addConverterFactory(GsonConverterFactory.create())
                 .build();
         ApiInterface apiInterface = retrofit.create(ApiInterface.class);
         Call<List<Post>> call = apiInterface.getPosts();
         call.enqueue(new Callback<List<Post>>() {
             @Override
             public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                 if(response.isSuccessful()){
                     data = response.body();
                     recyclerViewAdapter = new RecyclerViewAdapter(data);
                     Log.d("Error", "onCreate: ArrayAdapter init");
                     rv.setAdapter(recyclerViewAdapter);
                     Log.d("Error", "onCreate: ArrayAdapter setting adapter");

                 }

             }

             @Override
             public void onFailure(Call<List<Post>> call, Throwable t) {
                 Log.e("Error", "onFailure: No Response " +t.getMessage() );
             }
         });


    }
}