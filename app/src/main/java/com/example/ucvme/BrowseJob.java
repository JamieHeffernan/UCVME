package com.example.ucvme;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toolbar;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class BrowseJob extends AppCompatActivity {

    //UI Views
    RecyclerView recyclerView;
    ViewAdapter viewAdapter;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        //find recycler view and manage layout
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<MainModel> options =
                new FirebaseRecyclerOptions.Builder<MainModel>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("Jobs"), MainModel.class)
                .build();

        //create a new viewAdapter with a set query and display this as the current
        viewAdapter = new ViewAdapter(options);
        recyclerView.setAdapter(viewAdapter);

        //find FAB button
        floatingActionButton = (FloatingActionButton)findViewById(R.id.floatingActionButton5);

        //add OnClickListener to FAB button
        floatingActionButton.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                //start AddActivity class when FAB button pressed
                startActivity(new Intent(getApplicationContext(), AddActivity.class));
            }
        });
    }

    //onStart of search listen for new queries
    @Override
    protected void onStart() {
        super.onStart();
        viewAdapter.startListening();
    }

    //onStop of search stop listening for new queries
    @Override
    protected void onStop() {
        super.onStop();
        viewAdapter.stopListening();
    }

    //onCreateOptionsMenu of search menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //get the search menu and display
        getMenuInflater().inflate(R.menu.search,menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView)item.getActionView();

        //allow for queries within the search
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //set the textSearch as the users query
                textSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                textSearch(query);
                return false;
            }
        });

        //return new query into the search menu
        return super.onCreateOptionsMenu(menu);
    }

    //function for textSearch
    private void textSearch(String s)
    {
        //get Jobs table from Firebase and search users query
        FirebaseRecyclerOptions<MainModel> options =
                new FirebaseRecyclerOptions.Builder<MainModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Jobs").orderByChild("name").startAt(s).endAt(s+"~"), MainModel.class)
                        .build();

        //create a new viewAdapter for user
        viewAdapter = new ViewAdapter(options);
        viewAdapter.startListening();
        recyclerView.setAdapter(viewAdapter);
    }
}