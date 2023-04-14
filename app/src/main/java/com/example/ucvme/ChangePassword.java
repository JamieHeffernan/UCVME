package com.example.ucvme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class ChangePassword extends AppCompatActivity {

    //UI Elements
    EditText editTextPass, editTextConfirmPass;
    Button confirmBtn;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        //initialise UI views
        editTextPass = findViewById(R.id.passChange);
        editTextConfirmPass = findViewById(R.id.confirmPass);
        confirmBtn = findViewById(R.id.confirmBtn);
        progressBar = findViewById(R.id.progressBar);

        //onClick listener for confirm password button
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                String pass, confirmPass;
                pass = String.valueOf(editTextPass.getText());
                confirmPass = String.valueOf(editTextConfirmPass.getText());

                //checks if email field is empty
                if (TextUtils.isEmpty(pass)){
                    Toast.makeText(ChangePassword.this, "Enter Valid Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                //checks if password field is empty
                if (TextUtils.isEmpty(confirmPass)){
                    Toast.makeText(ChangePassword.this, "Please Confirm Password", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }
}