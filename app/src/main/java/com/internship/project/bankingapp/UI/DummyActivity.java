package com.internship.project.bankingapp.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.internship.project.bankingapp.Database.UsersDatabase;
import com.internship.project.bankingapp.Database.UsersTransactionsDatabase;
import com.internship.project.bankingapp.Helper.DialogBox;
import com.internship.project.bankingapp.HomeScreen;
import com.internship.project.bankingapp.R;

public class DummyActivity extends AppCompatActivity implements DialogBox.DialogListener {

    TextView msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy);
        getSupportActionBar().hide();
        msg = findViewById(R.id.textView8);

            openDialog();

    }
    void openDialog(){
        DialogBox dialogBox = new DialogBox();
        dialogBox.show(getSupportFragmentManager(),"Enter amount");
    }
    @Override
    public void applyTest(String amount) {
        msg.setText(amount);
        perform_Transection();
    }
    void perform_Transection(){


        String toUserName = getIntent().getStringExtra("UserName");
        String toUserAcNumber = getIntent().getStringExtra("accountNo");
        String toUserBalance =  getIntent().getStringExtra("availableBalanceOfUser");
        String fromUserName = getIntent().getStringExtra("fromUserName");
        String fromUserAcNumberReceived = getIntent().getStringExtra("fromUserAcNo");
        String fromUserBalanceReceived =  getIntent().getStringExtra("fromUserAcBalance");
        getIntent().setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        Log.i("balance" , " : "+fromUserAcNumberReceived);
        Log.i("acNo" , " : "+fromUserBalanceReceived);
        Log.i("name " , " : "+fromUserName);
        Log.i("toUserName " , " : "+toUserName);
        Log.i("toUserAcNumber " , " : "+toUserAcNumber);
        Log.i("toUserBalance " , " : "+toUserBalance);



        String amountSended;
        amountSended = msg.getText().toString();
        Log.i("amountSended " , " : "+amountSended);
        int balanceRecieved = Integer.parseInt(amountSended);
        int FUserBalance = Integer.parseInt(fromUserBalanceReceived);
        int FuserAccount = Integer.parseInt(fromUserAcNumberReceived);
        int ToUserAccount = Integer.parseInt(toUserAcNumber);
        int ToUserBalance = Integer.parseInt(toUserBalance);
        if(amountSended.isEmpty()){
            msg.setText("you haven't entered any amount");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Toast.makeText(this, "Transaction  failed", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext() , User.class));

            finish();
        }
        else if(balanceRecieved < 0){
            msg.setText("Invalid amount , request cant process");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Toast.makeText(this, "Transaction  failed", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext() , User.class));
            finish();
        }
        else if(FUserBalance < balanceRecieved){
            msg.setText("Insufficient balance");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Toast.makeText(this, "Transaction  failed", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext() , User.class));
            finish();}
        else if(balanceRecieved < 1000){
            msg.setText("amount should be more than 1000");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Toast.makeText(this, "Transaction  failed", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext() , User.class));
            finish();
        }
        else{
            ToUserBalance = ToUserBalance+balanceRecieved ;
            FUserBalance = FUserBalance - balanceRecieved;

            UsersDatabase database = new UsersDatabase(this);
            UsersTransactionsDatabase db = new UsersTransactionsDatabase(this);
            database.updateAmount(FuserAccount ,FUserBalance);
            database.updateAmount(ToUserAccount ,ToUserBalance);
            db.insertTransferData(fromUserName ,toUserName ,balanceRecieved);
            database.close();
            db.close();
            msg.setText("money transferred successful");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Toast.makeText(this, "Transaction successful view transaction history", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext() , HomeScreen.class));
            finish();
            }
    }
}