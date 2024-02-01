package com.example.currency;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText amountEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        amountEditText = findViewById(R.id.amount);
        RadioButton c1RadioButton = findViewById(R.id.c1);
        RadioButton c2RadioButton = findViewById(R.id.c2);
        resultTextView = findViewById(R.id.result);


        c1RadioButton.setOnClickListener(v -> calculateAndDisplayResult(true));

        c2RadioButton.setOnClickListener(v -> calculateAndDisplayResult(false));
    }

    @SuppressLint("SetTextI18n")
    private void calculateAndDisplayResult(boolean isC1Selected) {

        String amountStr = amountEditText.getText().toString();

        if (!amountStr.isEmpty()) {
            double amount = Double.parseDouble(amountStr);
            double result = isC1Selected ? amount * 3 : amount / 3;
            resultTextView.setText(String.valueOf(result));
        } else {
            resultTextView.setText("Enter a valid amount");
        }
    }
}
