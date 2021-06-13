package com.internship.project.bankingapp.Helper;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.internship.project.bankingapp.R;
import com.internship.project.bankingapp.UI.DummyActivity;
import com.internship.project.bankingapp.UI.TransactionHistory;
import com.internship.project.bankingapp.UI.User;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SendToUserAdapter extends RecyclerView.Adapter<SendToUserDataViewHolder> {
   ArrayList<SendToUserDataModel> transactionData ;

    public SendToUserAdapter(Context context ,ArrayList<SendToUserDataModel> transactionData) {
        this.transactionData = transactionData;
    }

    @NonNull
    @NotNull
    @Override
    public SendToUserDataViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.select_single_user , parent,false);
        return new SendToUserDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull SendToUserDataViewHolder holder, int position) {
        final SendToUserDataModel data_model = transactionData.get(position);

        holder.SendToUseraccounterName.setText(transactionData.get(position).getUserName());
        holder.SendToUseraccountNumber.setText(transactionData.get(position).getAccountNo());
        holder.accounterBalance.setText(transactionData.get(position).getAvailableBalanceOfUser());
        holder.transferBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // to user details
                Intent intent = new Intent(v.getContext() , DummyActivity.class);
                intent.putExtra("UserName" , data_model.getUserName());
                intent.putExtra("accountNo" , data_model.getAccountNo());
                intent.putExtra("availableBalanceOfUser" , data_model.getAvailableBalanceOfUser());
                intent.putExtra("fromUserName" , data_model.getFromUserName());


                Log.i("in adapter FName " ,":"+data_model.getFromUserName());
                Log.i("in adapter FacNo " ,":"+data_model.getFromUserAcNo());
                Log.i("in adapter Facbal " ,":"+data_model.getFromUserAcBalance());


                intent.putExtra("fromUserAcNo" , data_model.getFromUserAcNo());
                intent.putExtra("fromUserAcBalance" , data_model.getFromUserAcBalance());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return transactionData.size();
    }
}
