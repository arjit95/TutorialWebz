package com.tutorialwebz.linearlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button linearLayout,relativeLayout,coordinatorLayout,appBarLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = (Button) findViewById(R.id.linear_layout);
        relativeLayout = (Button) findViewById(R.id.relative_layout);
        coordinatorLayout = (Button) findViewById(R.id.coordinator_layout);
        appBarLayout = (Button) findViewById(R.id.app_bar_layout);
        bindViews();
    }
    private void bindViews(){
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(),LinearLayout.class);
                startActivity(i);
            }
        });
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(),RelativeLayout.class);
                startActivity(i);
            }
        });
        coordinatorLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(),ScrollingActivity.class);
                startActivity(i);
            }
        });
        appBarLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(),AppBarLayout.class);
                startActivity(i);
            }
        });
    }
}
