package com.example.don8;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {
    public final static String DATABASE_URL = "https://don8-8acd8.firebaseio.com/";


    private TextView profile_name;
    private TextView company_id;
    private TextView num_donations;
    private TextView donation_value;
    private ProgressBar progressBar;

    private Button liability_laws;
    private TextView liability_link_one;
    private TextView liability_link_two;
    private TextView liability_link_three;
    private TextView liability_header_one;
    private TextView liability_header_two;
    private TextView liability_header_three;
    private TextView progress_label;
    private Boolean isRestaurant;

    private Button contact_us;
    private Button donate;

    private TextView contact_number;
    private TextView contact_email;
    private TextView email_header;
    private TextView phone_header;

    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth firebaseAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_history:
                        startActivity(new Intent(ProfileActivity.this, HistoryActivity.class));
                        break;
                    case R.id.action_data:
                        startActivity(new Intent(ProfileActivity.this, AnalyticsActivity.class));                        break;
                    case R.id.action_donate:
                        startActivity(new Intent(ProfileActivity.this, ConfirmationActivity.class));                        break;
                    case R.id.action_profile:
                        //startActivity(new Intent(ProfileActivity.this, ProfileActivity.class));
                        break;
                }
                return true;
            }
        });

        profile_name = findViewById(R.id.profile_name);
        company_id = findViewById(R.id.company_id);
        contact_us = findViewById(R.id.contact_us);
        donation_value = findViewById(R.id.donation_value);
        progressBar = findViewById(R.id.progressBar);
        liability_laws = findViewById(R.id.liability_laws);
        contact_us = findViewById(R.id.contact_us);

        liability_link_one = findViewById(R.id.liability_link_one);
        liability_link_two = findViewById(R.id.liability_link_two);
        liability_link_three = findViewById(R.id.liability_link_three);
        liability_header_one = findViewById(R.id.liability_header_one);
        liability_header_two = findViewById(R.id.liability_header_two);
        liability_header_three = findViewById(R.id.liability_header_three);

        contact_number = findViewById(R.id.contact_phone);
        contact_email = findViewById(R.id.contact_email);
        email_header = findViewById(R.id.email_header);
        phone_header = findViewById(R.id.phone_header);
        progress_label = findViewById(R.id.progress_label);
        //progressBar.setProgress(20);

        donate = findViewById(R.id.donate);
        isRestaurant = true;

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

//        FirebaseUser currUser = firebaseAuth.getCurrentUser();
//        DatabaseReference userReference = firebaseDatabase.getReferenceFromUrl(DATABASE_URL + "/" + currUser.getUid());
//        userReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                UserObject object = dataSnapshot.getValue(UserObject.class);
//                System.out.println(object);
////                profile_name.setText(object.getName());
////                company_id.setText(object.getEmail());
////                contact_email.setText(object.getEmail());
////                contact_number.setText(object.getPhoneNumber());
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });


        if(!isRestaurant) {
            //donation_value.setVisibility(View.INVISIBLE);
            progress_label.setText("Capacity Filled");
        }

        contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(contact_number.getVisibility() == View.GONE){
                    contact_number.setVisibility(View.VISIBLE);
                    contact_email.setVisibility(View.VISIBLE);
                    email_header.setVisibility(View.VISIBLE);
                    phone_header.setVisibility(View.VISIBLE);
                }
                else{
                    contact_number.setVisibility(View.GONE);
                    contact_email.setVisibility(View.GONE);
                    email_header.setVisibility(View.GONE);
                    phone_header.setVisibility(View.GONE);
                }

            }
        });

        liability_laws.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(liability_link_one.getVisibility() == View.GONE){
                    liability_link_one.setVisibility(View.VISIBLE);
                    liability_link_two.setVisibility(View.VISIBLE);
                    liability_link_three.setVisibility(View.VISIBLE);
                    liability_header_one.setVisibility(View.VISIBLE);
                    liability_header_two.setVisibility(View.VISIBLE);
                    liability_header_three.setVisibility(View.VISIBLE);
                }
                else{
                    liability_link_one.setVisibility(View.GONE);
                    liability_link_two.setVisibility(View.GONE);
                    liability_link_three.setVisibility(View.GONE);
                    liability_header_one.setVisibility(View.GONE);
                    liability_header_two.setVisibility(View.GONE);
                    liability_header_three.setVisibility(View.GONE);
                }
            }
        });


        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Second argument is the class to switch to
                Intent intent = new Intent(getBaseContext(), ConfirmationActivity.class);

                //To pass info to the new screen. Name of the variable, value of variable
                //intent.putExtra("mame", name);

                startActivity(intent);

            }
        });
    }

    public void visible(){

    }

}
