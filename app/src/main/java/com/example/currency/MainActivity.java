package com.example.currency;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText amountEditText;
    private TextView resultTextView;
    private RadioButton c1RadioButton;
    private RadioButton c2RadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amountEditText = findViewById(R.id.amount);
        resultTextView = findViewById(R.id.result);
        c1RadioButton = findViewById(R.id.c1);
        c2RadioButton = findViewById(R.id.c2);
        Button convertButton = findViewById(R.id.convertButton);

        convertButton.setOnClickListener(v -> convert());
    }

    @SuppressLint("SetTextI18n")
    private void convert() {
        String amountStr = amountEditText.getText().toString();

        if (!amountStr.isEmpty() && isNumeric(amountStr)) {
            double amount = Double.parseDouble(amountStr);
            double result = 0;
            if (c1RadioButton.isChecked()) {
                result = amount * 3;
                resultTextView.setText(String.valueOf(result));
            } else if (c2RadioButton.isChecked()) {
                result = amount / 3;
                resultTextView.setText(String.valueOf(result));
            }
            else{
                resultTextView.setText("Please choose an operation");
            }

        }
        else {
            resultTextView.setText("Invalid");
        }
    }

    public static boolean isNumeric(String str){
        try {
            Double.parseDouble(str);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}
