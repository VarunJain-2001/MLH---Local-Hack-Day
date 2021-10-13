package com.example.don8;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private Button restaurant;
    private Button donation;
    private Button login;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home); // says which screen to display on launch

        restaurant = findViewById(R.id.restaurant);
        donation = findViewById(R.id.donation);
        login = findViewById(R.id.login);

        donation.setEnabled(false);

        restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUpIntent= new Intent(HomeActivity.this, RestaurantSignUpActivity.class);
                startActivity(signUpIntent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent= new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });
    }

}
