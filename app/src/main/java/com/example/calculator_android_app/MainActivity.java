package com.example.calculator_android_app;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private static final char OPERATOR_ADD = '+';
    private static final char OPERATOR_SUBTRACT = '-';
    private static final char OPERATOR_MULTIPLY = 'x';
    private static final char OPERATOR_DIVIDE = '/';

    private char currentOperator;
    private double firstOperand = Double.NaN;
    private double secondOperand;
    private TextView inputDisplay, OutputDisplay;
    private DecimalFormat decimalFormat;
    private MaterialButton button1, button2, button3, button4, button5, button6, button7, button8,
            button9, button0, buttonAdd, buttonSubtract, buttonMultiply, buttonDivide, buttonDot,
            buttonEquals, buttonOff, buttonClear, buttonPercent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        decimalFormat = new DecimalFormat("0.##########");
        inputDisplay = findViewById(R.id.input);
        OutputDisplay = findViewById(R.id.output);
        button1 = findViewById(R.id.no1);
        button2 = findViewById(R.id.no2);
        button3 = findViewById(R.id.no3);
        button4 = findViewById(R.id.no4);
        button5 = findViewById(R.id.no5);
        button6 = findViewById(R.id.no6);
        button7 = findViewById(R.id.no7);
        button8 = findViewById(R.id.no8);
        button9 = findViewById(R.id.no9);
        button0 = findViewById(R.id.no0);

        buttonEquals = findViewById(R.id.equals);
        buttonOff = findViewById(R.id.off);
        buttonClear = findViewById(R.id.clear);
        buttonDot = findViewById(R.id.dot);
        buttonAdd = findViewById(R.id.addition);
        buttonSubtract = findViewById(R.id.subtraction);
        buttonDivide = findViewById(R.id.division);
        buttonMultiply = findViewById(R.id.multiply);
        buttonPercent = findViewById(R.id.percent);

        button1.setOnClickListener(v -> inputDisplay.setText(inputDisplay.getText() + "1"));
        button2.setOnClickListener(v -> inputDisplay.setText(inputDisplay.getText() + "2"));
        button3.setOnClickListener(v -> inputDisplay.setText(inputDisplay.getText() + "3"));
        button4.setOnClickListener(v -> inputDisplay.setText(inputDisplay.getText() + "4"));
        button5.setOnClickListener(v -> inputDisplay.setText(inputDisplay.getText() + "5"));
        button6.setOnClickListener(v -> inputDisplay.setText(inputDisplay.getText() + "6"));
        button7.setOnClickListener(v -> inputDisplay.setText(inputDisplay.getText() + "7"));
        button8.setOnClickListener(v -> inputDisplay.setText(inputDisplay.getText() + "8"));
        button9.setOnClickListener(v -> inputDisplay.setText(inputDisplay.getText() + "9"));
        button0.setOnClickListener(v -> inputDisplay.setText(inputDisplay.getText() + "0"));
        buttonDot.setOnClickListener(v -> inputDisplay.setText(inputDisplay.getText() + "."));
        buttonAdd.setOnClickListener(v -> {
            currentOperator = OPERATOR_ADD;
            firstOperand = Double.parseDouble(inputDisplay.getText().toString());
            inputDisplay.setText("");
        });

        buttonSubtract.setOnClickListener(v -> {
            currentOperator = OPERATOR_SUBTRACT;
            firstOperand = Double.parseDouble(inputDisplay.getText().toString());
            inputDisplay.setText("");
        });
        buttonMultiply.setOnClickListener(v -> {
            currentOperator = OPERATOR_MULTIPLY;
            firstOperand = Double.parseDouble(inputDisplay.getText().toString());
            inputDisplay.setText("");
        });
        buttonDivide.setOnClickListener(v -> {
            currentOperator = OPERATOR_DIVIDE;
            firstOperand = Double.parseDouble(inputDisplay.getText().toString());
            inputDisplay.setText("");
        });
        buttonOff.setOnClickListener(v -> {
            firstOperand = Double.NaN;
            inputDisplay.setText("");
            OutputDisplay.setText("");
        });

        buttonClear.setOnClickListener(v -> {
            firstOperand = Double.NaN;
            inputDisplay.setText("");
            OutputDisplay.setText("");
        });
        buttonPercent.setOnClickListener(v -> {
            currentOperator = '%';
            firstOperand = Double.parseDouble(inputDisplay.getText().toString());
            inputDisplay.setText("");
        });
        buttonEquals.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                secondOperand = Double.parseDouble(inputDisplay.getText().toString());
                allCalculations();
                OutputDisplay.setText(decimalFormat.format(firstOperand));
                firstOperand = Double.NaN;
                currentOperator = '0';
        }});

    }

    private void allCalculations(){
        try {
            switch (currentOperator) {
                case OPERATOR_ADD:
                    firstOperand = this.firstOperand + secondOperand;
                    break;
                case OPERATOR_SUBTRACT:
                    firstOperand = this.firstOperand - secondOperand;
                    break;
                case OPERATOR_MULTIPLY:
                    firstOperand = this.firstOperand * secondOperand;
                    break;
                case OPERATOR_DIVIDE:
                    firstOperand = this.firstOperand / secondOperand;
                    break;
                case '%':
                    firstOperand = this.firstOperand / 100;
                    break;
            }
        } catch (Exception e) {
            OutputDisplay.setText("Error");
        }
    }
}