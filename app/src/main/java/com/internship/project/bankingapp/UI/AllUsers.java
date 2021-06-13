package com.internship.project.bankingapp.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import com.internship.project.bankingapp.Database.UsersDatabase;
import com.internship.project.bankingapp.Helper.UserAdapter;
import com.internship.project.bankingapp.Helper.UserDataModel;
import com.internship.project.bankingapp.R;

import java.util.ArrayList;

public class AllUsers extends AppCompatActivity {

    RecyclerView recyclerView;
    UserAdapter userAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_users);
        getSupportActionBar().hide();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        userAdapter = new UserAdapter(this ,dataModelArrayList());
        recyclerView.setAdapter(userAdapter);
    }


    public ArrayList<UserDataModel> dataModelArrayList(){
        ArrayList<UserDataModel> model = new ArrayList<>();
        Cursor cursor = new UsersDatabase(this).readAllUsersData();
        int nameColumnIndex = cursor.getColumnIndex(UsersDatabase.Col2);
        int balanceColumnIndex = cursor.getColumnIndex(UsersDatabase.Col3);
        int accountNoColumnIndex = cursor.getColumnIndex(UsersDatabase.Col1);
        while(cursor.moveToNext())
        {
            String username = cursor.getString(nameColumnIndex);
            String accountBalance = cursor.getString(balanceColumnIndex);
            String accountNo = cursor.getString(accountNoColumnIndex);
            model.add(new UserDataModel(username, accountNo,accountBalance));
        }
       return model;
    }
}