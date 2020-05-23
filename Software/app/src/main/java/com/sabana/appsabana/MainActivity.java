package com.sabana.appsabana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //region References to views
    private EditText userEditText;
    private EditText passwordEditText;
    private Button loginButton;
    //endregion

    //region overridden methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        
    }
    //endregion

    //region private methods
    private void init() {
        userEditText = findViewById(R.id.user_text);
        passwordEditText = findViewById(R.id.password_text);
        loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        String userName= userEditText.getText().toString().trim();
        char [] password = passwordEditText.getText().toString().trim().toCharArray();

        if (userName.isEmpty()) {
            userEditText.setError(getResources().getString(R.string.user_required));
            return;
        }

        if (password.length == 0) {
            passwordEditText.setError(getResources().getString(R.string.password_required));
            return;
        }

        //Consume services

        if (true) {
            goToNextActivity();
        }
    }

    private void goToNextActivity() {
        startActivity(new Intent(this, MainMenu.class));
    }
    //endregion
}
