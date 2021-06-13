package com.internship.project.bankingapp.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import com.internship.project.bankingapp.Database.UsersDatabase;
import com.internship.project.bankingapp.Helper.SendToUserAdapter;
import com.internship.project.bankingapp.Helper.SendToUserDataModel;
import com.internship.project.bankingapp.R;

import java.util.ArrayList;

public class SelectUserToTransfer extends AppCompatActivity {
    RecyclerView recyclerViewsendTouser;
    SendToUserAdapter userAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_user_to_transfer);
        getSupportActionBar().hide();
        recyclerViewsendTouser = findViewById(R.id.recyclerViewSendToUser);
        recyclerViewsendTouser.setLayoutManager(new LinearLayoutManager(this));
        int acno = Integer.parseInt(getIntent().getStringExtra("FromUseraccountNo"));
        String  acBal = getIntent().getStringExtra("FromUserbalance");
        String accountNov = getIntent().getStringExtra("FromUseraccountNo");
        String fromUserName = getIntent().getStringExtra("FromUserName");
       /* Log.i("details" , " in above method ");
        Log.i("balance SelectUser" , " : "+acBal);
        Log.i("acNo SelectUser" , " : "+accountNov);*/
        userAdapter = new SendToUserAdapter(this ,dataModelArrayList(acno , acBal ,accountNov ,fromUserName));
        recyclerViewsendTouser.setAdapter(userAdapter);

        // receiving data which was send through intent ;


    }

    public ArrayList<SendToUserDataModel> dataModelArrayList(int anNO , String acbal , String fromUserAcNumber , String fromUserName){
        ArrayList<SendToUserDataModel> model = new ArrayList<>();
        Cursor cursor = new UsersDatabase(this).readAllUserDataExceptOne(anNO);
        int nameColumnIndex = cursor.getColumnIndex(UsersDatabase.Col2);
        int accountNoColumnIndex = cursor.getColumnIndex(UsersDatabase.Col1);
        int accountBalanceIndex = cursor.getColumnIndex(UsersDatabase.Col3);
        while(cursor.moveToNext())
        {
            String username = cursor.getString(nameColumnIndex);
            String accountNo = cursor.getString(accountNoColumnIndex);
            String balance = cursor.getString(accountBalanceIndex);

           /* Log.i("details" , " in below method ");
            Log.i("balance SelectUser" , " : "+acbal);
            Log.i("acNo SelectUser" , " : "+fromUserAcNumber);
            Log.i("name " , " : "+fromUserName);*/


            model.add(new SendToUserDataModel(username, accountNo , balance , fromUserName ,
                    fromUserAcNumber,acbal));
        }
        return model;
    }
}