package com.mvp.com.android_mvp_login_sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class UserProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        String fullName = intent.getStringExtra("fullName");
        String phone = intent.getStringExtra("phone");
        String address = intent.getStringExtra("address");

        TextView emailText = findViewById(R.id.email);
        TextView phoneText = findViewById(R.id.phone);
        TextView fullNmeText = findViewById(R.id.full_name);
        TextView addressText = findViewById(R.id.address);

        emailText.setText("Email: " + email);
        phoneText.setText("Full name: " + fullName);
        fullNmeText.setText("Phone: " + phone);
        addressText.setText("Address: " + address);

    }
}
