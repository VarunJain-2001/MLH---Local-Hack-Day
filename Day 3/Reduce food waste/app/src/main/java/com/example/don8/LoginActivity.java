package com.example.don8;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button login;
    private ProgressBar load;
    private FirebaseAuth firebaseAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login); // says which screen to display on launch
//        firebaseAuth = FirebaseAuth.getInstance();
//
//        email = findViewById(R.id.email);
//        password = findViewById(R.id.password);
          load = findViewById(R.id.loading);

        login = findViewById(R.id.login);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String inputtedEmail = email.getText().toString().trim();
//                String inputtedPassword = password.getText().toString();

                load.setVisibility(View.VISIBLE);
//                setAllEnabled(false);

                Intent profileIntent = new Intent(LoginActivity.this, ProfileActivity.class);
                startActivity(profileIntent);

//                firebaseAuth.signInWithEmailAndPassword(inputtedEmail, inputtedPassword).addOnCompleteListener(new OnCompleteListener() {
//                    @Override
//
//                    public void onComplete(@NonNull Task task) {
//                        System.out.println("Before if**********************");
//                        if (task.isSuccessful()) {
//                            System.out.println("Inside if**********************");
//                            Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
//
//                            Intent profileIntent = new Intent(LoginActivity.this, ProfileActivity.class);
//                            startActivity(profileIntent);
//                        } else {
//                            Toast.makeText(LoginActivity.this, "Login error", Toast.LENGTH_SHORT);
//                        }
//                    }
//                });
            }
        });
    }

//    private void setAllEnabled(boolean enable) {
//        email.setEnabled(enable);
//        password.setEnabled(enable);
//        login.setEnabled(enable);
//    }
}
