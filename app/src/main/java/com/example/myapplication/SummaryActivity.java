package com.example.myapplication;

import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "NAME";
    public static final String EXTRA_EMAIL = "EMAIL";
    public static final String EXTRA_NUMBER = "NUMBER";

    TextView tvName, tvEmail;
    Button btnConfirm;
    Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        btnConfirm = findViewById(R.id.btnConfirm);

        btnShare = findViewById(R.id.btnShare);

        Intent intent = getIntent();

        String name = intent.getStringExtra(EXTRA_NAME);
        String email = intent.getStringExtra(EXTRA_EMAIL);

        tvName.setText("Imię: " + name);
        tvEmail.setText("Email: " + email);

        btnShare.setOnClickListener(v -> {
            String summary = "Podsumowanie zgłoszenia:\n"
                    + "Imię: " + name + "\n"
                    + "Email: " + email;

            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, summary);

            Intent chooser = Intent.createChooser(
                    shareIntent,
                    "Udostępnij podsumowanie"
            );

            startActivity(chooser);
        });

        btnConfirm.setOnClickListener(v -> {

            Intent result = new Intent();

            result.putExtra(EXTRA_NUMBER, "ZG/4821");

            setResult(RESULT_OK, result);

            finish();
        });
    }
}