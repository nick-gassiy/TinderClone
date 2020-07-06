package com.example.tindercloneapp.Registration;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tindercloneapp.Helpers.Utils;
import com.example.tindercloneapp.R;
import com.example.tindercloneapp.Models.User;
import com.google.android.material.textfield.TextInputLayout;

public class EmailAndPasswordActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    private Button nextActivity;
    private String password;
    private String confirmPassword;
    private TextInputLayout confirmPasswordInputLayout;
    private static final String SYMBOLS = "[!#$:%&*()_+=|<>?{}\\[\\]~]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_and_password);

        nextActivity = findViewById(R.id.nextActivityButton);
        emailEditText = findViewById(R.id.registerEmailEditText);                                     // Ввод почты
        passwordEditText = findViewById(R.id.registerPasswordEditText);                               // Ввод пароля
        confirmPasswordEditText = findViewById(R.id.registerConfirmPasswordEditText);                 // Повторный ввод пароля
        confirmPasswordInputLayout = findViewById(R.id.confirmPasswordTextInput);

        User user = new User();
        nextActivity.setOnClickListener(v -> register(user));
    }

    // Продолжить регистрацию
    private void register(User user) {
        Intent intent = new Intent(EmailAndPasswordActivity.this, NameActivity.class);
        password = passwordEditText.getText().toString().trim();
        confirmPassword = confirmPasswordEditText.getText().toString().trim();
        if (!isEmailExist()) {
            //Проверки корректности пароля
            if ((!(Utils.isFieldNotValid(password, SYMBOLS))) && (!(Utils.isFieldNotValid(confirmPassword, SYMBOLS))))
                confirmPasswordInputLayout.setError("Некоректный пароль");
            else if (!(password.equals(confirmPassword)))
                confirmPasswordInputLayout.setError("Пароли не совпадают");
            else if (((passwordEditText.length() < 7) && (confirmPasswordEditText.length() < 7)))
                confirmPasswordInputLayout.setError("Пароль должен содержать более 7 символов");
            else {
                user.setPassword(passwordEditText.getText().toString().replace(" ", ""));
                user.setMail(emailEditText.getText().toString().trim());
                startActivity(Utils.goToNextActivity(user, intent));
            }
        } else
            Toast.makeText(this, "Данная почта уже зарегестрирована", Toast.LENGTH_LONG).show();
    }

    // Проверка наличия введенной почты в БД
    private boolean isEmailExist() {
        return false;
    }
}
