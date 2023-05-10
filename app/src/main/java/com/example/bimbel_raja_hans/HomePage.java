package com.example.bimbel_raja_hans;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomePage extends AppCompatActivity {
    TextView tv_username;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    PagerAdaptor pagerAdaptor;
    FirebaseDatabase firebaseDatabase;
    FirebaseAuth mAuth;
    DatabaseReference userRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        tv_username = findViewById(R.id.userName);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager);
        setViewPager2(viewPager2);
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> tab.setText(pagerAdaptor.getFragmentTitle(position))).attach();
        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance("https://bimbel-raja-hans-default-rtdb.asia-southeast1.firebasedatabase.app/");
        FirebaseUser firebaseUser = mAuth.getCurrentUser();
        userRef = firebaseDatabase.getReference().child("users").child(firebaseUser.getUid());

        ProgressDialog progressDialog = new ProgressDialog(HomePage.this);
        progressDialog.setTitle("Please wait. . .");
        progressDialog.setMessage("Processing account");
        progressDialog.setCancelable(false);
        progressDialog.show();

        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String nama = snapshot.child("nama").getValue().toString();
                tv_username.setText(nama);

                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void setViewPager2(ViewPager2 viewPager2) {
        if (pagerAdaptor == null) {
            pagerAdaptor = new PagerAdaptor(this);
            pagerAdaptor.addFragment(new FirstFragment(), "Counter");
            pagerAdaptor.addFragment(new SecondFragment(), "Area Calc");
            pagerAdaptor.addFragment(new ThirdFragment(), "Volume Calc");
            viewPager2.setAdapter(pagerAdaptor);
        }
    }
}