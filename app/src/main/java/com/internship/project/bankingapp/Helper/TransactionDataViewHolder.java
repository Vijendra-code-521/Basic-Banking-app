package com.internship.project.bankingapp.Helper;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.internship.project.bankingapp.R;

import org.jetbrains.annotations.NotNull;

public class TransactionDataViewHolder extends RecyclerView.ViewHolder {
    TextView to_user , from_user , amount ;
    public TransactionDataViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        to_user = itemView.findViewById(R.id.toUser);
        from_user = itemView.findViewById(R.id.fromUser);
        amount = itemView.findViewById(R.id.Amount);

    }
}
