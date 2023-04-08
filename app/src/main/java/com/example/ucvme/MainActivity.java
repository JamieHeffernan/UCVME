package com.example.ucvme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    //UI views
    FirebaseAuth auth;
    FirebaseUser user;
    Button logOut;
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

        //initialise UI views
        auth = FirebaseAuth.getInstance();
        logOut = findViewById(R.id.logOut);
        user = auth.getCurrentUser();

        //if user does not exist bring back to Login Activity
        if (user == null) {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        }

        //onClick listener for Log Out Button, logs user out and brings back to Login Activity
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });

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