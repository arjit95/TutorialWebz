package com.tutorialwebz.linearlayout;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class AppBarLayout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_bar_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        RecyclerView rv= (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerViewAdapter mAdapter = new RecyclerViewAdapter(this);
        mAdapter.add(0,"Jan");
        mAdapter.add(1,"Feb");
        mAdapter.add(2,"Mar");
        mAdapter.add(3,"Apr");
        mAdapter.add(4,"May");
        mAdapter.add(5,"Jun");
        mAdapter.add(6,"July");
        mAdapter.add(7,"Aug");
        mAdapter.add(8,"Sept");
        mAdapter.add(9,"Oct");
        mAdapter.add(10,"Nov");
        mAdapter.add(11,"Dec");
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(mAdapter);
    }

}
