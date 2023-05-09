package com.example.bimbel_raja_hans;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText emailField, passField;
    Button loginBtn;
    TextView regisLink;
    ProgressBar progressBar;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailField = findViewById(R.id.email);
        passField = findViewById(R.id.pass);
        loginBtn = findViewById(R.id.btn_login);
        regisLink = findViewById(R.id.link_register);
        progressBar = findViewById(R.id.progressbar);
        mAuth = FirebaseAuth.getInstance();

        regisLink.setOnClickListener(view -> {
            Intent regisIntent = new Intent(Login.this, Register.class);
            startActivity(regisIntent);
        });
        loginBtn.setOnClickListener(view -> {
            progressBar.setVisibility(View.VISIBLE);
            String email = emailField.getText().toString();
            String pass = passField.getText().toString();
            mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(Login.this, task -> {
                progressBar.setVisibility(View.GONE);
                if (!task.isSuccessful()) {
                    Toast.makeText(this, "Login gagal", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show();
                    Intent home = new Intent(Login.this, HomePage.class);
                    startActivity(home);
                    finish();
                }
            });
        });
    }
}