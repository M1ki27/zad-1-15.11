package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail;
    Button btnNext;

    private final ActivityResultLauncher<Intent> summaryLauncher =
            registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
                    result -> {

                        if (result.getResultCode() == RESULT_OK &&
                                result.getData() != null) {

                            String number = result.getData()
                                    .getStringExtra(SummaryActivity.EXTRA_NUMBER);

                            Toast.makeText(this,
                                    "Zapisano: " + number,
                                    Toast.LENGTH_LONG).show();
                        }
                    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(v -> {

            String name = etName.getText().toString();
            String email = etEmail.getText().toString();

            Intent intent = new Intent(MainActivity.this, SummaryActivity.class);

            intent.putExtra(SummaryActivity.EXTRA_NAME, name);
            intent.putExtra(SummaryActivity.EXTRA_EMAIL, email);

            summaryLauncher.launch(intent);
        });
    }
}