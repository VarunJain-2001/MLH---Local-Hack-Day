package com.example.don8;

import com.example.don8.UserObject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthActionCodeException;
import com.google.firebase.auth.FirebaseAuthEmailException;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RestaurantSignUpActivity extends AppCompatActivity {
    public final static String DATABASE_URL = "https://don8-8acd8.firebaseio.com/";

    private EditText name;
    private EditText email;
    private EditText password;
    private EditText phoneNumber;
    private EditText address;
    private EditText city;
    private EditText state;
    private EditText zipCode;
    private CheckBox veggies;
    private CheckBox fruit;
    private CheckBox grains;
    private CheckBox cans;
    private CheckBox meals;
    private RadioGroup dropOff;
    private RadioButton yes;
    private RadioButton no;
    private Button create;

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        phoneNumber = findViewById(R.id.phone);
        address = findViewById(R.id.address);
        city = findViewById(R.id.city);
        state = findViewById(R.id.state);
        zipCode = findViewById(R.id.zip_code);
        veggies = findViewById(R.id.veggies);
        fruit = findViewById(R.id.fruit);
        grains = findViewById(R.id.grains);
        cans = findViewById(R.id.canned_goods);
        meals = findViewById(R.id.meals);
        dropOff = findViewById(R.id.drop_off_radio);
        yes = findViewById(R.id.yes_button);
        create = findViewById(R.id.create_profile);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String inputtedName = name.getText().toString().trim();
                final String inputtedEmail = email.getText().toString().trim();
                final String inputtedPassword = password.getText().toString();
                final String inputtedNumber = phoneNumber.getText().toString().trim();
                final String inputtedAddress = address.getText().toString().trim();
                final String inputtedCity = city.getText().toString().trim();
                final String inputtedState = state.getText().toString().trim();
                final String inputtedZip = zipCode.getText().toString().trim();
                final boolean hasVeggies = veggies.isChecked();
                final boolean hasFruit = fruit.isChecked();
                final boolean hasGrains = grains.isChecked();
                final boolean hasCans = cans.isChecked();
                final boolean hasMeals = meals.isChecked();
                final boolean canDropOff = (dropOff.getCheckedRadioButtonId() == yes.getId());


                firebaseAuth.createUserWithEmailAndPassword(inputtedEmail, inputtedPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            UserObject currUser = new UserObject(inputtedName, inputtedEmail, inputtedPassword,
                                    inputtedNumber, inputtedAddress, inputtedCity, inputtedState, inputtedZip, hasVeggies,
                                    hasFruit, hasGrains, hasCans, hasMeals, canDropOff);
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            Toast.makeText(RestaurantSignUpActivity.this, "User created successfully", Toast.LENGTH_SHORT).show();

                            DatabaseReference databaseReference = firebaseDatabase.getReferenceFromUrl(DATABASE_URL);
                            databaseReference.push().setValue(currUser);

                            Intent profileIntent = new Intent(RestaurantSignUpActivity.this, ProfileActivity.class);
                            startActivity(profileIntent);
                        } else {
                            Toast.makeText(RestaurantSignUpActivity.this, "Couldn't create user", Toast.LENGTH_SHORT);
                        }
                    }
                });

            }
        });
    }


}
