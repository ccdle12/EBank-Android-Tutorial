package com.example.christophercoverdale.ebank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class UserAccountActivity extends AppCompatActivity
{
    Button logoutButton;
    Button depositButton;
    Button withdrawButton;
    TextView accountBalance;
    TextView welcomeMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);

        findAllViews();
        unpackIntent();
        setupLogoutButton();
        setupDepositButtonListener();
        setupWithdrawButtonListener();
    }

    private void findAllViews()
    {
        logoutButton = (Button) findViewById(R.id.logoutButton);
        depositButton = (Button) findViewById(R.id.depositButton);
        withdrawButton = (Button) findViewById(R.id.withdrawButton);
        accountBalance = (TextView) findViewById(R.id.accountBalance);
        welcomeMessage = (TextView) findViewById(R.id.userAccountWelcome);
    }

    private void unpackIntent()
    {
        welcomeMessage.setText("Welcome " + getIntent().getStringExtra("username"));
    }

    private void setupLogoutButton()
    {
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void setupDepositButtonListener()
    {
        depositButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String balance = accountBalance.getText().toString();

                int numBalance = Integer.valueOf(balance);

                numBalance += 10;

                final String updatedBalance = String.valueOf(numBalance);

                accountBalance.post(new Runnable() {
                    @Override
                    public void run() {
                        accountBalance.setText(updatedBalance);
                    }
                });

            }
        });
    }

    private void setupWithdrawButtonListener()
    {
        withdrawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String balance = accountBalance.getText().toString();

                int numBalance = Integer.valueOf(balance);

                numBalance -= 10;

                final String updatedBalance = String.valueOf(numBalance);

                accountBalance.post(new Runnable() {
                    @Override
                    public void run() {
                        accountBalance.setText(updatedBalance);
                    }
                });

            }
        });
    }

}
