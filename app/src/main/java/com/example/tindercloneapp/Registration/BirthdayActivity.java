package com.example.tindercloneapp.Registration;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.tindercloneapp.Models.User;
import com.example.tindercloneapp.R;

import java.util.Calendar;

public class BirthdayActivity extends AppCompatActivity {

    private DatePickerDialog.OnDateSetListener dateSetListener;
    private Button nextBirthActivityButton;
    private TextView displayDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);

        Intent givenIntent = getIntent();
        User user = givenIntent.getParcelableExtra("user");
        Intent intent = new Intent(BirthdayActivity.this, AdditionalActivity.class);

        nextBirthActivityButton = findViewById(R.id.nextBirthActivityButton);
        displayDate = findViewById(R.id.setDate);
        displayDate.setOnClickListener(v -> {
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog = new DatePickerDialog(BirthdayActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, dateSetListener,
                    year, month, day);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        });
        dateSetListener = (view, year, month, dayOfMonth) -> {
            month += 1;
            String date = dayOfMonth + "." + month + "." + year;
            user.setBirthday(date);
        };
    }
}
