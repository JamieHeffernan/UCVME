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
    Button browseProfile;
    Button browseJobs;
    Button editProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialise UI views
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        editProfile = findViewById(R.id.editprofilebutton);
        logOut = findViewById(R.id.logOut);
        browseProfile = findViewById(R.id.browseprofilebutton);
        createJob = findViewById(R.id.createjobbutton);
        browseJobs = findViewById(R.id.browsejobsbutton);

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
        browseProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BrowseProfiles.class);
                startActivity(intent);
                finish();
            }
        });

        //Button to go to create job
        createJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CreateJob.class);
                startActivity(intent);
                finish();
            }
        });

        //Button to go to browse jobs
        browseJobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BrowseJobs.class);
                startActivity(intent);
                finish();
            }
        });

        //Button to go to edit profile
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EditProfile.class);
                startActivity(intent);
                finish();
            }
        });

    }
}