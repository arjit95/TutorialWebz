package com.tutorialwebz.gridlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class GridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        GridView gv = (GridView) findViewById(R.id.grid);
        final GridViewAdapter mAdapter = new GridViewAdapter();
        if (gv != null) {
            gv.setAdapter(mAdapter);
            gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    int id = (int) mAdapter.getItem(i);
                    Intent intent = new Intent(getBaseContext(),SingleImageActivity.class);
                    intent.putExtra("id",id);
                    startActivity(intent);
                }
            });
        }
    }
}
