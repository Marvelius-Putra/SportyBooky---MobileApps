package com.example.sportybooky;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
//delcare component variables
    TextView log;
    EditText user_email, user_username, user_password, user_passconfirm;
    String email, username, password, passconfirm, userID;
    Button btnRegis;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseDatabase fDatabase;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        access the layout activity
        setContentView(R.layout.activity_register);

        //      access the layout component
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        log = (TextView) findViewById(R.id.go_login);

//      Method to go loginpage
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, MainActivity.class ));
            }
        });

//        access the variable to component id
        user_email = findViewById(R.id.email_register);
        user_username = findViewById(R.id.username_register);
        user_password = findViewById(R.id.password_register);
        user_passconfirm = findViewById(R.id.passconf_register);
        btnRegis = findViewById(R.id.btn_register);
        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }
//regis method
    private void register() {
//        get the user input
        fDatabase = FirebaseDatabase.getInstance();
        reference = fDatabase.getReference("users");
        email = user_email.getText().toString().trim();
        username = user_username.getText().toString().trim();
        password = user_password.getText().toString().trim();
        passconfirm = user_passconfirm.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            user_email.setError("Email is required");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            user_password.setError("Password is required");
            return;
        }

        if (TextUtils.isEmpty(passconfirm)) {
            user_password.setError("Password Confirmation is required");
            return;
        }

//        insert to databse
        fAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(RegisterActivity.this, "Register Success", Toast.LENGTH_LONG).show();
                            userID = fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fStore.collection("users").document(userID);
                            Map<String, Object> user = new HashMap<>();
                            user.put("UserID", userID);
                            user.put("Name", username);
                            user.put("Email", email);

                            documentReference.set(user).addOnSuccessListener((OnSuccessListener) (aVoid) -> {
                                Log.d("TAG", "onSuccess: User Profile is created for" + userID);
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d("TAG", "onFailure: " + e.toString());
                                }
                            });
//                            UserModel user = new UserModel(username, email, password, userID);
                            reference.child(userID).setValue(user);
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));

//                            Log.d(TAG, "signInWithCustomToken:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(RegisterActivity.this, "Register Failed", Toast.LENGTH_LONG).show();
//                            Log.w(TAG, "signInWithCustomToken:failure", task.getException());
//                            Toast.makeText(CustomAuthActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }
                    }
                });


//        Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
//        intent.putExtra("id", userID);
//        intent.putExtra("username", username);
//        intent.putExtra("email", email);
//        startActivity(intent);
    }


}