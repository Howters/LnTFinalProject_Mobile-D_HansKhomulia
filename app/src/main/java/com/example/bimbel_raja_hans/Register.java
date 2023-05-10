package com.example.bimbel_raja_hans;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    EditText idField, emailField, namaField, passField, confPassField;
    TextView loginLink;
    Button regisBtn;
    ProgressBar progressBar;
    FirebaseAuth mAuth;
    FirebaseDatabase fDatabase;
    DatabaseReference userRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        idField = findViewById(R.id.id_bimbel);
        emailField = findViewById(R.id.email);
        namaField = findViewById(R.id.nama);
        passField = findViewById(R.id.pass);
        confPassField = findViewById(R.id.conf_pass);
        loginLink = findViewById(R.id.link_login);
        regisBtn = findViewById(R.id.btn_regis);
        progressBar = findViewById(R.id.progressbar);
        mAuth = FirebaseAuth.getInstance();
        fDatabase = FirebaseDatabase.getInstance("https://bimbel-raja-hans-default-rtdb.asia-southeast1.firebasedatabase.app/");

        loginLink.setOnClickListener(view -> {
            Intent loginIntent = new Intent(Register.this, Login.class);
            startActivity(loginIntent);
        });

        regisBtn.setOnClickListener(view -> {
            if (TextUtils.isEmpty(idField.getText())) {
                Toast.makeText(this, "ID required", Toast.LENGTH_SHORT).show();
            } else if (!(emailField.getText().toString().contains("@") && emailField.getText().toString().endsWith(".com"))) {
                Toast.makeText(this, "Email harus terdapat '@' dan diakhiri dengan '.com'", Toast.LENGTH_LONG).show();
            } else if (namaField.getText().toString().length() < 5) {
                Toast.makeText(this, "Nama minimal 5 huruf", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(passField.getText())) {
                Toast.makeText(this, "Password required", Toast.LENGTH_SHORT).show();
            } else if (!(confPassField.getText().toString().equals(passField.getText().toString()))) {
                Toast.makeText(this, "Konfirmasi Password tidak sama dengan Password", Toast.LENGTH_LONG).show();
            } else {
                progressBar.setVisibility(View.VISIBLE);
                String idBimbel = idField.getText().toString();
                String email = emailField.getText().toString();
                String nama = namaField.getText().toString();
                String pass = passField.getText().toString();

                mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(Register.this, task -> {
                    if (task.isSuccessful()) {
                        userRef = fDatabase.getReference().child("users").child(mAuth.getCurrentUser().getUid());
                        userRef.setValue(new User(idBimbel, email, nama, pass));
                        userRef.push();
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(this, "Registrasi berhasil", Toast.LENGTH_SHORT).show();
                        Intent loginIntent = new Intent(Register.this, Login.class);
                        startActivity(loginIntent);
                    } else {
                        progressBar.setVisibility(View.GONE);
                        Toast.makeText(this, "Gagal registrasi", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}