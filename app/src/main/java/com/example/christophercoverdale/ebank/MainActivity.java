package com.example.christophercoverdale.ebank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    final String correctUsername = "chris123";
    final String correctPassword = "1234";

    EditText usernameInput;
    EditText passwordInput;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findAllViews();
        setupLoginButtonListener();
    }

    private void findAllViews()
    {
        usernameInput = (EditText) findViewById(R.id.userNameInput);
        passwordInput = (EditText) findViewById(R.id.passwordInput);
        loginButton = (Button) findViewById(R.id.loginButton);
    }

    private void setupLoginButtonListener()
    {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();

                if (username.equals(correctUsername) && password.equals(correctPassword))
                {
                    Toast loginSuccessToast = Toast.makeText(getApplicationContext(), "Login Success!", Toast.LENGTH_LONG);
                    loginSuccessToast.show();

                    Log.d("BUTTON", "Correct password!");
                    Log.d("BUTTON", "username: " + username);
                    Log.d("BUTTON", "password: " + password);

                    Intent launchUserAccount = new Intent(MainActivity.this, UserAccountActivity.class);
                    launchUserAccount.putExtra("username", correctUsername);
                    startActivity(launchUserAccount);

                }
                else
                {
                    Toast loginFailToast = Toast.makeText(getApplicationContext(), "Login Failed!", Toast.LENGTH_LONG);
                    loginFailToast.show();
                    Log.d("BUTTON", "INCORRECT PASSWORD!");
                }

            }
        });
    }

}
