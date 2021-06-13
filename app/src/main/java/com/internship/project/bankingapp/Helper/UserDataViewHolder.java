package com.internship.project.bankingapp.Helper;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.internship.project.bankingapp.R;

public class UserDataViewHolder extends RecyclerView.ViewHolder {
     TextView accountNumber , accountBalance , accounterName;
    public UserDataViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
        super(itemView);
        accountNumber = (TextView)itemView.findViewById(R.id.accountNO);
        accountBalance =(TextView)itemView.findViewById(R.id.accountbalance);
        accounterName = (TextView)itemView.findViewById(R.id.userName);
    }
}
