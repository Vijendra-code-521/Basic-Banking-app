package com.internship.project.bankingapp.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import com.internship.project.bankingapp.Database.UsersDatabase;
import com.internship.project.bankingapp.Database.UsersTransactionsDatabase;
import com.internship.project.bankingapp.Helper.DialogBox;
import com.internship.project.bankingapp.Helper.SendToUserDataModel;
import com.internship.project.bankingapp.Helper.TransactionAdapter;
import com.internship.project.bankingapp.Helper.TransactionDataModel;
import com.internship.project.bankingapp.Helper.UserAdapter;
import com.internship.project.bankingapp.Helper.UserDataModel;
import com.internship.project.bankingapp.R;

import java.util.ArrayList;

public class TransactionHistory extends AppCompatActivity {
    RecyclerView recyclerView;
    TransactionAdapter transactionAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);
        getSupportActionBar().hide();
        recyclerView = findViewById(R.id.transactionView);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        transactionAdapter = new TransactionAdapter(this ,dataModelArrayList());
        recyclerView.setAdapter(transactionAdapter);
    }
    public ArrayList<TransactionDataModel> dataModelArrayList(){
        ArrayList<TransactionDataModel> model = new ArrayList<>();
        Cursor cursor = new UsersTransactionsDatabase(this).readAllUsersData();
       // transaction data from database will be shown here
        int FromnameColumnIndex = cursor.getColumnIndex(UsersTransactionsDatabase.SENDER);
        int toNameColumnIndex = cursor.getColumnIndex(UsersTransactionsDatabase.RECEIVER);
        int amountSendColumnIndex = cursor.getColumnIndex(UsersTransactionsDatabase.AMOUNT);
        while(cursor.moveToNext())
        {
            String fromusername = cursor.getString(FromnameColumnIndex);
            String tousername = cursor.getString(toNameColumnIndex);
            String amount = cursor.getString(amountSendColumnIndex);
            model.add(new TransactionDataModel(fromusername,tousername,amount));
        }
        return model;
    }
}