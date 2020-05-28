package com.sabana.appsabana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sabana.appsabana.modelos.User;
import com.sabana.appsabana.servicios.APIService;
import com.sabana.appsabana.servicios.APIUtils;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        String password = passwordEditText.getText().toString().trim();

        if (userName.isEmpty()) {
            userEditText.setError(getResources().getString(R.string.user_required));
            return;
        }

        if (password.isEmpty()) {
            passwordEditText.setError(getResources().getString(R.string.password_required));
            return;
        }

        //Consume services

        APIService service = APIUtils.getAPIService();

        Map<String, String> params = new HashMap();

        params.put("user", userName);
        params.put("password", password);

        Call<User> call = service.login(params);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();

                goToNextActivity(user);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this, getResources().getString(R.string.error_login), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void goToNextActivity(User user) {
        Intent intent = new Intent(this, MainMenu.class);
        intent.putExtra("User", user);
        startActivity(intent);
    }
    //endregion
}
