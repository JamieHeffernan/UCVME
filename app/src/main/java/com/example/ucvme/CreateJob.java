package com.example.ucvme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateJob extends Activity {

    Button browseJobs;
    Intent switchBrowseJobs;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_job);

        //Button to go to browse jobs
        browseJobs = (Button) findViewById(R.id.browse_jobs);
        switchBrowseJobs = new Intent(CreateJob.this,
                BrowseJobs.class);

        browseJobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(switchBrowseJobs);
            }
        });


    }


}
