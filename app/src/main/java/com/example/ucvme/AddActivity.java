package com.example.ucvme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddActivity extends AppCompatActivity {

    //UI views
    EditText name,job,email,jurl;
    Button btnAdd,btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        //initialise UI views
        name = (EditText)findViewById(R.id.nameText);
        job = (EditText)findViewById(R.id.jobText);
        email = (EditText)findViewById(R.id.emailText);
        jurl = (EditText)findViewById(R.id.imageTextUrl);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnBack = (Button)findViewById(R.id.btnBack);

        //add OnClickListener to add button
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call function
                if (name.getText().toString().equals("") || job.getText().toString().equals("") || email.getText().toString().equals("")) {
                    Toast.makeText(AddActivity.this, "Name, Job and Email Are Required", Toast.LENGTH_SHORT).show();
                } else {
                    insertData();
                    clearAll();
                }
            }
        });

        //add OnClickListener to add button
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finish action
                finish();
            }
        });
    }

    //insert data function
    private void insertData() {
        //initialise a Hashmap
        Map<String,Object> map = new HashMap<>();
        //put new data into appropriate attributes
        map.put("name", name.getText().toString());
        map.put("job", job.getText().toString());
        map.put("email", email.getText().toString());
        map.put("jurl", jurl.getText().toString());

        //push updated data into table Jobs
        FirebaseDatabase.getInstance().getReference().child("Jobs").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        //on success of pushing data display toast message
                        Toast.makeText(AddActivity.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //on failure of pushing data display toast message
                        Toast.makeText(AddActivity.this, "Error while inserting...", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    //clearAll function
    private void clearAll() {
        //set all editTexts to empty
        name.setText("");
        job.setText("");
        email.setText("");
        jurl.setText("");
    }
}