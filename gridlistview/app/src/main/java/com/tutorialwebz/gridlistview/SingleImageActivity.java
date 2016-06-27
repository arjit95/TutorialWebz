package com.tutorialwebz.gridlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class SingleImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_item);
        Intent intent = getIntent();
        if(intent!=null) {
            int id = intent.getIntExtra("id",0);
            if(id!=0)
                ((ImageView)findViewById(R.id.SingleView)).setImageResource(id);
        }
    }
}
