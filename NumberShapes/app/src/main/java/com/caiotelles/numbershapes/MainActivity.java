package com.caiotelles.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    class Number {
        int number;

        public boolean isSquare() {
            double squareRoot = Math.sqrt(number);

            if (squareRoot == Math.floor(squareRoot))
                    return true;
            return false;
        }

        public  boolean isTriangular() {
            int x = 1;

            int triangularNumber = 1;

            while (triangularNumber < number) {
                x++;
                triangularNumber += x;
            }
            if (triangularNumber == number)
                return true;
            return false;
        }
    }

    public void testNumber(View view) {
        EditText usersNumber = findViewById(R.id.usersNumber);

        Log.i("Number",usersNumber.getText().toString());

        String message = "";

        if (usersNumber.getText().toString().isEmpty())
            message = "Please enter a number!";
        else {
            Number myNumber = new Number();

            try {
                myNumber.number = Integer.parseInt(usersNumber.getText().toString());
                if (myNumber.isSquare()) {
                    if (myNumber.isTriangular())
                        message = myNumber.number + " is both triangular and square!";
                    else
                        message = myNumber.number + " is just square!";
                } else if (myNumber.isTriangular()) {
                    message = myNumber.number + " is just triangular!";
                } else
                    message = myNumber.number + "is neither square nor triangular";

            } catch (NumberFormatException error) {
                message = "Put a correct Number!";
            }

            Toast.makeText(this, message, Toast.LENGTH_LONG).show();

            System.out.println(myNumber.isSquare());
        }
    }
}
