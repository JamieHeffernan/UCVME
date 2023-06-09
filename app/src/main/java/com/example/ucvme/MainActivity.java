package com.example.ucvme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    //UI views
    FirebaseAuth auth;
    FirebaseUser user;

    TextView details;
    Button logOut;
    Button browseJobs;
    Button editProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialise UI views
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        details = findViewById(R.id.userDetails);
        editProfile = findViewById(R.id.editprofilebutton);
        logOut = findViewById(R.id.logOut);
        browseJobs = findViewById(R.id.browsejobsbutton);

        //if user does not exist bring back to Login Activity
        if (user == null) {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        }
        else {
            //set textView as current users email
            details.setText(user.getEmail());
        }

        //onClick listener for Log Out Button, logs user out and brings back to Login Activity
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sign out user out of Firebase instance
                FirebaseAuth.getInstance().signOut();
                //bring user back into login Activity
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });

        //Button to go to browse jobs
        browseJobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BrowseJob.class));
            }
        });

        //Button to go to edit profile
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, EditProfile.class));
            }
        });

    }
}