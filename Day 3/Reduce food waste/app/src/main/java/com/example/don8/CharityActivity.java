package com.example.don8;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class CharityActivity extends AppCompatActivity {

    private Button match;
    private Button ok;
    private ImageView charity;
    //private ImageView success;
    private TextView success;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.charity); // says which screen to display on launch
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_history:
                        startActivity(new Intent(CharityActivity.this, HistoryActivity.class));
                        break;
                    case R.id.action_data:
                        startActivity(new Intent(CharityActivity.this, DataActivity.class));                        break;
                    case R.id.action_donate:
                        startActivity(new Intent(CharityActivity.this, MapsActivity.class));                        break;
                    case R.id.action_profile:
                        startActivity(new Intent(CharityActivity.this, ProfileActivity.class));
                        break;
                }
                return true;
            }
        });
        match = findViewById(R.id.match);
        ok = findViewById(R.id.okay);
        charity = findViewById(R.id.charity);
        success = findViewById(R.id.textView16);

        match.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                success.setVisibility(View.VISIBLE);
                ok.setVisibility(View.VISIBLE);
            }
        }));

        ok.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                success.setVisibility(View.GONE);
                ok.setVisibility(View.GONE);
                Toast.makeText(CharityActivity.this, "Donation Confirmed " , Toast.LENGTH_SHORT).show();
                Intent profileIntent = new Intent(CharityActivity.this, ProfileActivity.class);
                startActivity(profileIntent);
            }
        }));
    }
}
