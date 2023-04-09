package com.example.ucvme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class EditProfile extends AppCompatActivity {

    //UI views
    FloatingActionButton addVideosBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        //change actionbar title
        setTitle("Videos");


        //initialise views
        addVideosBtn = findViewById(R.id.addVideosBtn);

        //handle clicks
        addVideosBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //start to add videos
                startActivity(new Intent(EditProfile.this, UploadVideo.class));
            }
        });

    }
}
