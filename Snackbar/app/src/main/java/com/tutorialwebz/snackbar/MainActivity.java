package com.tutorialwebz.snackbar;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    View parent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parent = findViewById(R.id.coordinator_layout);
        findViewById(R.id.simple).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(parent, "Simple Snackbar Example", Snackbar.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.custom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(parent, "Message is deleted", Snackbar.LENGTH_SHORT)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(getBaseContext(), "Your custom action", Toast.LENGTH_SHORT).show();
                            }
                        });
                // Changing message text color
                snackbar.setActionTextColor(Color.RED);

                // Changing action button text color
                View custom_view = snackbar.getView();
                TextView textView = (TextView) custom_view.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.GREEN);
                custom_view.setBackgroundColor(Color.YELLOW);
                snackbar.show();
            }
        });
        findViewById(R.id.callback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(parent, "Message is deleted", Snackbar.LENGTH_SHORT)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(getBaseContext(), "Your custom action", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });
    }
}