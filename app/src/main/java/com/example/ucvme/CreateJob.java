package com.example.ucvme;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import java.util.Calendar;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateJob extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private DatePickerDialog datePickerDialog;
    private Button dateButton;
    private ActionBar actionBar;
    private DatabaseReference mDatabase;
    FirebaseAuth auth;
    FirebaseUser user;
    Button browseJobs, addJobs;
    EditText addCounty, addLocation, addDescription, addTitle, addWage;
    Spinner addJobType;
    Intent switchBrowseJobs;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_job);

        // Get current user
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        // Initialise calendar elements
        initDatePicker();
        dateButton = findViewById(R.id.datePickerButton);
        dateButton.setText(getTodaysDate());

        // Get instance of DatabaseReference
        mDatabase = FirebaseDatabase.getInstance().getReference();

        // Initialise UI elements
        addTitle = findViewById(R.id.title);
        addWage = findViewById(R.id.wage);
        addCounty = findViewById(R.id.county);
        addLocation = findViewById(R.id.location);
        addJobType = findViewById(R.id.jobType);
        addDescription = findViewById(R.id.description);
        addJobs = findViewById(R.id.create_ad);
        browseJobs = findViewById(R.id.browse_jobs);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.jobType_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        addJobType.setAdapter(adapter);
        addJobType.setOnItemSelectedListener(this);

        // initialise actionbar
        actionBar = getSupportActionBar();
        // title
        actionBar.setTitle("Create Job");

        // Button to go to browse jobs
        switchBrowseJobs = new Intent(CreateJob.this,
                BrowseJobs.class);
        browseJobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(switchBrowseJobs);
            }
        });

        // Button to add job
        addJobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeNewJob();
            }
        });

    }

    // Get current date
    private String getTodaysDate()
    {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    // Initialise Date Picker
    private void initDatePicker()
    {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                month = month + 1;
                String date = makeDateString(day, month, year);
                dateButton.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);

    }

    // Format Date
    private String makeDateString(int day, int month, int year)
    {
        return day + "/" + month + "/" + year;
    }


    public void openDatePicker(View view)
    {
        datePickerDialog.show();
    }

    // Add job to Database
    public void writeNewJob() {
        // Create id = timestamp + jobLocation
        String timestamp = addLocation.getText().toString() + System.currentTimeMillis();

        Job job = new Job(addTitle.getText().toString(),
                addWage.getText().toString(),
                addCounty.getText().toString(),
                addLocation.getText().toString(),
                addJobType.getSelectedItem().toString(),
                addDescription.getText().toString(),
                dateButton.getText().toString(),
                user.getEmail(),
                timestamp);

        mDatabase.child("jobs").child(timestamp).setValue(job);
    }

    // Retrieve selected item
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
         parent.getItemAtPosition(pos);
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

}
