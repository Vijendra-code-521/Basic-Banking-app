package com.internship.project.bankingapp.Helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.internship.project.bankingapp.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionDataViewHolder> {

    ArrayList<TransactionDataModel> TransactionHistory;

    public TransactionAdapter(Context context ,ArrayList<TransactionDataModel> transactionHistory) {
        TransactionHistory = transactionHistory;
    }

    @NonNull
    @NotNull
    @Override
    public TransactionDataViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_user_transaction , parent,false);
        return new TransactionDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TransactionDataViewHolder holder, int position) {
        holder.from_user.setText(TransactionHistory.get(position).getFromUser());
        holder.to_user.setText(TransactionHistory.get(position).getToUser());
        holder.amount.setText(TransactionHistory.get(position).getAmount());
    }

    @Override
    public int getItemCount() {
        return TransactionHistory.size();
    }
}
