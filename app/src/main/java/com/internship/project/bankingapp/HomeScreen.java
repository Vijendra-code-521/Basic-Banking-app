package com.internship.project.bankingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.internship.project.bankingapp.UI.AllUsers;
import com.internship.project.bankingapp.UI.TransactionHistory;

public class HomeScreen extends AppCompatActivity {

    Button usersBtn , allTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        getSupportActionBar().hide();
        usersBtn = findViewById(R.id.button_user);
        allTransaction = findViewById(R.id.AllTransaction);
        usersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext() , AllUsers.class));
            }
        });
        allTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext() , TransactionHistory.class));
                finish();
            }
        });
    }
}