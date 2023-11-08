package com.example.sanpablook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class signUp extends AppCompatActivity {

    private DatePickerDialog datePickerDialog;
    private Button dateButton;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        textView=(TextView) findViewById(R.id.alreadyBtn);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signUp.this, MainActivity.class);
                startActivity(intent);

            }
        });


        initDatePicker();
        dateButton = findViewById(R.id.datePickerButton);
        dateButton.setText(getTodaysDate());
    }

    private String getTodaysDate()
    {
        Calendar cal= Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month= month + 1;
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(dayOfMonth, month, year);
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = makeDateString(dayOfMonth, month, year);
                dateButton.setText(date);
            }

        };

        Calendar cal= Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, dayOfMonth);

    }
            private String makeDateString(int dayOfMonth, int month, int year)
            {
                return getMonthFormat(month) + " " + dayOfMonth + " " + year;

            }
            private String getMonthFormat(int month) {
                if (month == 1)
                    return "January";
                if (month == 2)
                    return "February";
                if (month == 3)
                    return "March";
                if (month == 4)
                    return "April";
                if (month == 5)
                    return "May";
                if (month == 6)
                    return "June";
                if (month == 7)
                    return "July";
                if (month == 8)
                    return "August";
                if (month == 9)
                    return "September";
                if (month == 10)
                    return "October";
                if (month == 11)
                    return "November";
                if (month == 12)
                    return "December";

                return "October";
            }

            public void openDatePicker(View view)
             {
                datePickerDialog.show();
            }
        };



