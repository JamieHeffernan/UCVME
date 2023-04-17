package com.example.ucvme;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class BrowseJobs extends AppCompatActivity {

    private ActionBar actionBar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_jobs);

        //initialise actionbar
        actionBar = getSupportActionBar();
        //title
        actionBar.setTitle("Browse Jobs");

    }

}
