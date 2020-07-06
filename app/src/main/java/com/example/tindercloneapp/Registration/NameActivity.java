package com.example.tindercloneapp.Registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.tindercloneapp.Helpers.Utils;
import com.example.tindercloneapp.R;
import com.example.tindercloneapp.Models.User;
import com.google.android.material.textfield.TextInputLayout;

public class NameActivity extends AppCompatActivity {

    private Button registerNameButton;
    private EditText nameEditText;
    private TextInputLayout nameTextInputLayout;
    private static final String SYMBOLS1 = "[!@#$:%&*()+=|<>?{}\\[\\]~]";
    private static final String SYMBOLS2 = "[0-9]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        nameEditText = findViewById(R.id.registerNameEditText);
        registerNameButton = findViewById(R.id.registerNameBtn);
        nameTextInputLayout = findViewById(R.id.nameTextInputLayout);

        Intent givenIntent = getIntent();
        User user = givenIntent.getParcelableExtra("user");
        Intent intent = new Intent(NameActivity.this, BirthdayActivity.class);

        registerNameButton.setOnClickListener(v -> {
            String tmp =  nameEditText.getText().toString().trim();
            if (Utils.isFieldNotValid(tmp, SYMBOLS1, SYMBOLS2))
                nameTextInputLayout.setError("Ошибка ввода имени пользователя");
            else {
                user.setName(tmp);
                startActivity(Utils.goToNextActivity(user, intent));
            }
        });
    }
}
