package com.example.lab6_3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText inputField;
    private String currentInput = "";
    private double currentValue = 0.0;
    private String currentOperator = "";
    private Calculator calculator = new Calculator(); // Instantiate the Calculator

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputField = findViewById(R.id.inputField);
    }

    public void onButtonClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();

        if (buttonText.equals("Clear")) {
            currentInput = "";
            currentOperator = "";
            currentValue = 0.0;
        } else if (buttonText.equals("+/-")) {
            if (!currentInput.isEmpty()) {
                double number = Double.parseDouble(currentInput);
                currentInput = String.valueOf(-number);
            }
        } else if (buttonText.equals("Back")) {
            if (!currentInput.isEmpty()) {
                currentInput = currentInput.substring(0, currentInput.length() - 1);
            }
        } else if (isOperator(buttonText)) {
            if (!currentInput.isEmpty()) {
                if (!currentOperator.isEmpty()) {
                    calculateResult();
                }

                currentOperator = buttonText;
                currentValue = Double.parseDouble(currentInput);
                currentInput = "";
            }
        } else {
            currentInput += buttonText;
        }

        inputField.setText(currentInput);
    }

    public void onEqualsClick(View view) {
        if (!currentInput.isEmpty() && !currentOperator.isEmpty()) {
            calculateResult();
        }
    }

    public void calculateResult() {
        try {
            double secondValue = Double.parseDouble(currentInput);
            double result = calculator.performOperation(currentValue, secondValue, currentOperator);

            currentValue = result;
            currentInput = "";
            currentOperator = "";
            inputField.setText(String.valueOf(result));
        } catch (ArithmeticException e) {
            inputField.setText("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            inputField.setText("Error: Invalid input");
        }
    }

    private boolean isOperator(String text) {
        return text.equals("+") || text.equals("-") || text.equals("*") || text.equals("/") || text.equals("√");
    }
}