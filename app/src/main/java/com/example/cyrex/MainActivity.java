package com.example.cyrex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ArrayList<Model> data = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> mImagesUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getImages();

    }
    private void getImages(){
        Log.d(TAG, "initImageBitmaps: preparing item");
        data.add(new Model("Cyberpunk 2077", R.drawable.cyberpunk,"Action","RPG","Synopsis", getString(R.string.cyberpunk), R.drawable.cyberpunk,R.drawable.arrow,"Trailer","BO8lX3hDU30","https://store.steampowered.com/agecheck/app/1091500/"));
        data.add(new Model("Resident evil",R.drawable.evil,"Action","Horror","Synopsis",getString(R.string.resident_evil), R.drawable.resident_evil,R.drawable.arrow,"Trailer","W1OUs3HwIuo","https://store.steampowered.com/app/418370/Resident_Evil_7_Biohazard/"));
        data.add(new Model("Rocket League",R.drawable.rocket,"Sport","Online","Synopsis",getString(R.string.rocket_league), R.drawable.cars,R.drawable.arrow,"Trailer","R2ir3viLzg4","https://store.steampowered.com/news/app/252950"));
       // data.add(new Model("Sekiro", R.drawable.sekiro,"Action","Adventure","Synopsis",getString(R.string.Sekiro),R.drawable.another_sekiro,R.drawable.arrow,"rXMX4YJ7Lks"));
        initRecyclerView();
    }
    private void initRecyclerView(){
        Log.d(TAG, "initRecycleView: init recyclerview");
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, data);
        recyclerView.setAdapter(adapter);
    }
}