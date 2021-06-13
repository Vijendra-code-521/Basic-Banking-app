package com.internship.project.bankingapp.Helper;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.internship.project.bankingapp.R;
import com.internship.project.bankingapp.UI.User;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserDataViewHolder> {
   ArrayList<UserDataModel> userData ;

    public UserAdapter(Context context, ArrayList<UserDataModel> userData) {
        this.userData = userData;
    }

    @NonNull
    @NotNull
    @Override
    public UserDataViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_card_view , parent,false);
        return new UserDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull UserDataViewHolder holder, int position) {
        final UserDataModel data_model = userData.get(position);

        holder.accounterName.setText(userData.get(position).getFromUserName());
        holder.accountBalance.setText(userData.get(position).getFromUserbalance());
        holder.accountNumber.setText(userData.get(position).getFromUseraccountNo());

        holder.accounterName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), User.class);
                intent.putExtra("FromUserName" , data_model.getFromUserName());
                intent.putExtra("FromUseraccountNo" , data_model.getFromUseraccountNo());
                intent.putExtra("FromUserbalance" , data_model.getFromUserbalance());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return userData.size();
    }
}
