package com.internship.project.bankingapp.Helper;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.internship.project.bankingapp.R;

public class SendToUserDataViewHolder extends RecyclerView.ViewHolder {
     TextView SendToUseraccountNumber, SendToUseraccounterName , accounterBalance;
    TextView transferBtn;
    public SendToUserDataViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
        super(itemView);
        SendToUseraccountNumber = (TextView)itemView.findViewById(R.id.accountNoSendToUser);
        transferBtn =(TextView) itemView.findViewById(R.id.transferBtnsend);
        accounterBalance = (TextView)itemView.findViewById(R.id.availableBalance);
        SendToUseraccounterName = (TextView)itemView.findViewById(R.id.sendToUser);
    }
}
