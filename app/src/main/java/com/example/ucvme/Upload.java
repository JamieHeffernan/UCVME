package com.example.ucvme;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.VideoView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;


public class Upload extends AppCompatActivity {

    //UI views
    FloatingActionButton addVideosBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload);

        //change actionbar title
        setTitle("Videos");

        //initialise views
        addVideosBtn = findViewById(R.id.addVideosBtn);

        //handle clicks
        addVideosBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //start to add videos
                startActivity(new Intent(Upload.this, UploadVideo.class));
            }
        });

    }
}
