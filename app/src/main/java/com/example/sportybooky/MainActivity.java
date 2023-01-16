package com.example.sportybooky;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

//    declare variables
    TextView regis;
    EditText user_email, user_password;
    String email, password;
    Button btnLogin;

    private FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Access layout activity_main (login)
        setContentView(R.layout.activity_main);

//      access the layout component
        fAuth = FirebaseAuth.getInstance();
        regis = (TextView) findViewById(R.id.go_regis);
        user_email = (EditText) findViewById(R.id.email_login);
        user_password = (EditText) findViewById(R.id.password_login);
        btnLogin = findViewById(R.id.btn_login);

//        method to authentication
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cekLogin();
            }
        });
//        method to go register page
        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });
    }
//login method
    private void cekLogin() {
//        get the user input
        email = user_email.getText().toString().trim();
        password = user_password.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            user_email.setError("Email is required");
            return;
        }
        if(TextUtils.isEmpty(password)){
            user_password.setError("Password is required");
            return;
        }


//      check the inputed user to database
        fAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(MainActivity.this, HomeActivity.class));

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this, "Login Failed, credential not found",Toast.LENGTH_LONG).show();

                        }
                    }
                });


    }
}