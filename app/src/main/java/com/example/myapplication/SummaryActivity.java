package com.example.myapplication;

import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "NAME";
    public static final String EXTRA_EMAIL = "EMAIL";

    TextView tvName, tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);

        Intent intent = getIntent();

        String name = intent.getStringExtra(EXTRA_NAME);
        String email = intent.getStringExtra(EXTRA_EMAIL);

        tvName.setText("Imię: " + name);
        tvEmail.setText("Email: " + email);
    }
}