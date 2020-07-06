package com.example.tindercloneapp.Helpers;

import android.content.Intent;
import android.text.TextUtils;
import com.example.tindercloneapp.Models.User;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static Intent goToNextActivity(User user, Intent intent) {
        intent.putExtra("user", user);
        return intent;
    }

    public static boolean isFieldNotValid(String value, String symbols) {
        Pattern special = Pattern.compile (symbols);
        Matcher hasSpecial = special.matcher(value);
        return !(TextUtils.isEmpty(value) || hasSpecial.find());
    }

    public static boolean isFieldNotValid(String value, String symbols1, String symbols2) {
        Pattern digit = Pattern.compile(symbols1);
        Pattern special = Pattern.compile (symbols2);
        Matcher hasDigit = digit.matcher(value);
        Matcher hasSpecial = special.matcher(value);
        return (TextUtils.isEmpty(value) || hasDigit.find() || hasSpecial.find());
    }
}
