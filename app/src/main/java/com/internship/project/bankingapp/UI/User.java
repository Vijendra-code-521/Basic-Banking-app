package com.internship.project.bankingapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.internship.project.bankingapp.R;

public class User extends AppCompatActivity {

    TextView NameOfUser , AccountNoOfUser , AccountBalanceOfUser;
    Button transeferMoneyBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        getSupportActionBar().hide();
        NameOfUser = findViewById(R.id.textView3);
        AccountNoOfUser = findViewById(R.id.textView5);
        AccountBalanceOfUser = findViewById(R.id.textView7);
        transeferMoneyBtn = findViewById(R.id.button);

        NameOfUser.setText(getIntent().getStringExtra("FromUserName"));
        AccountNoOfUser.setText(getIntent().getStringExtra("FromUseraccountNo"));
        AccountBalanceOfUser.setText(getIntent().getStringExtra("FromUserbalance"));
        String ac = getIntent().getStringExtra("FromUseraccountNo");
        String no = getIntent().getStringExtra("FromUserbalance");

        Log.i("fromUser ac no " , " : "+ac);
        Log.i("fromUser balance  " , " : "+no);
        transeferMoneyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication() , SelectUserToTransfer.class);
                intent.putExtra("FromUserName" ,NameOfUser.getText().toString());
                intent.putExtra("FromUseraccountNo" ,ac);
                intent.putExtra("FromUserbalance" ,no);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                v.getContext().startActivity(intent);
                finish();
            }
        });
    }
}