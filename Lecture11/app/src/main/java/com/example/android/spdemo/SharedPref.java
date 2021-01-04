package com.example.android.spdemo;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {
    SharedPreferences sharedPref;

    public SharedPref(Context context) {
        sharedPref = context.getSharedPreferences("myPref", Context.MODE_PRIVATE);
    }

    public void SaveData(String username, String password) {
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("UserName", username);
        editor.putString("Password", password);
        editor.commit();
    }

    public String LoadData() {
        String fileContent = "UserName: " + sharedPref.getString("UserName", "No name");
        fileContent += ", Password: " + sharedPref.getString("Password", "No password");
        return fileContent;
    }
}
