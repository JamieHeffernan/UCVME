package com.example.ucvme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button createJob;
    Intent switchCreateJob;
    Button browseProfile;
    Intent switchBrowseProfile;
    Button browseJobs;
    Intent switchBrowseJobs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button to go to browse profiles
        browseProfile = (Button) findViewById(R.id.browseprofilebutton);
        switchBrowseProfile = new Intent(MainActivity.this,
                BrowseProfiles.class);

        browseProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(switchBrowseProfile);
            }
        });

        //Button to go to create job
        createJob = (Button) findViewById(R.id.createjobbutton);
        switchCreateJob = new Intent(MainActivity.this,
                CreateJob.class);

        createJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(switchCreateJob);
            }
        });

        //Button to go to browse jobs
        browseJobs = (Button) findViewById(R.id.browsejobsbutton);
        switchBrowseJobs = new Intent(MainActivity.this,
                BrowseJobs.class);

        browseJobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(switchBrowseJobs);
            }
        });
    }
}