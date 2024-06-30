package com.example.tutorial;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;

import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private EditText number1TextView;
    private EditText number2TextView;
    private int number1;
    private int number2;
    private TextView result;
    private EditText currentFocus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.textViewResult);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        number1TextView = findViewById(R.id.editTextN1);
        number2TextView = findViewById(R.id.editTextN2);

        number1TextView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    currentFocus = number1TextView;
                }
            }
        });

        number2TextView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    currentFocus = number2TextView;
                }
            }
        });

        findViewById(R.id.buttonOne).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumber(1);
            }
        });

        findViewById(R.id.buttonTwo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumber(2);
            }
        });

        findViewById(R.id.buttonThree).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumber(3);
            }
        });

        findViewById(R.id.buttonFour).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumber(4);
            }
        });

        findViewById(R.id.buttonFive).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumber(5);
            }
        });

        findViewById(R.id.buttonSix).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumber(6);
            }
        });

        findViewById(R.id.buttonSeven).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumber(7);
            }
        });

        findViewById(R.id.buttonEight).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumber(8);
            }
        });

        findViewById(R.id.buttonNine).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumber(9);
            }
        });

        findViewById(R.id.buttonZero).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayNumber(0);
            }
        });
    }

    private void displayResult(double value) {
        result.setText(String.valueOf(value));
    }

    private void parseNumbers() {
        try {
            String getNumber1 = number1TextView.getText().toString();
            number1 = Integer.parseInt(getNumber1);
            String getNumber2 = number2TextView.getText().toString();
            number2 = Integer.parseInt(getNumber2);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public double sum(double num1, double num2) {
        return num1 + num2;
    }

    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public double divide(double num1, double num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            Log.e(TAG, "Division by zero");
            return Double.NaN;
        }
    }

    public void displayNumber(int number) {
        if (currentFocus != null) {
            String currentNumber = currentFocus.getText().toString();
            if (currentNumber.length() < 8) {
                String newNumber = currentNumber + number;
                currentFocus.setText(newNumber);
            }
        }
    }

    public void onClickBtnAdd(View view) {
        parseNumbers();
        double sum = sum(number1, number2);
        displayResult(sum);
        Log.d(TAG, "sum: " + sum);
    }

    public void onClickBtnSub(View view) {
        parseNumbers();
        double subtract = subtract(number1, number2);
        displayResult(subtract);
        Log.d(TAG, "subtraction: " + subtract);
    }

    public void onClickBtnMlt(View view) {
        parseNumbers();
        double multiply = multiply(number1, number2);
        displayResult(multiply);
        Log.d(TAG, "multiplication: " + multiply);
    }

    public void onClickBtnDiv(View view) {
        parseNumbers();
        double division = divide(number1, number2);
        if (number2 != 0) {
            displayResult(division);
            Log.d(TAG, "division: " + division);
        } else {
            result.setText("Error: Division by zero");
        }
    }
}
