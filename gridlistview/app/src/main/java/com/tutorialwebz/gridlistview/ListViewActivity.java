package com.tutorialwebz.gridlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import android.widget.ListView;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListView lv = (ListView) findViewById(R.id.list);
        final ListViewAdapter mAdapter = new ListViewAdapter();
        if (lv != null) {
            lv.setAdapter(mAdapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    int id = (int) mAdapter.getItem(i);
                    Intent intent = new Intent(getBaseContext(), SingleImageActivity.class);
                    intent.putExtra("id", id);
                    startActivity(intent);
                }
            });
        }
    }
}
