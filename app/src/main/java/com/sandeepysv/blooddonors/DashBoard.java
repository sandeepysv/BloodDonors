package com.sandeepysv.blooddonors;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

@SuppressWarnings("ALL")
public class DashBoard extends AppCompatActivity implements View.OnClickListener {

    private TextView txtWelcome;
    private EditText input_new_password,input_reenter_new_password;
    private Button btnChangePass, btnLogout;
    private RelativeLayout activity_dashboard;

    private FirebaseAuth auth;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        //View
        txtWelcome = (TextView)findViewById(R.id.dashboard_welcome);
        input_new_password = (EditText)findViewById(R.id.dashboard_new_password);
        input_reenter_new_password = (EditText)findViewById(R.id.dashboard_input_reenter_new_password);
        btnChangePass = (Button)findViewById(R.id.dashboard_btn_change_pass);
        btnLogout = (Button)findViewById(R.id.dashboard_btn_logout);
        activity_dashboard = (RelativeLayout)findViewById(R.id.activity_dash_board);

        btnChangePass.setOnClickListener(this);
        btnLogout.setOnClickListener(this);

        //Init Firebase
        auth = FirebaseAuth.getInstance();

        //Session Check
        if(auth.getCurrentUser() != null) {
            txtWelcome.setText("Welcome, "+auth.getCurrentUser().getEmail());
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId()== R.id.dashboard_btn_change_pass)
            changePassword(input_new_password.getText().toString(),input_reenter_new_password.getText().toString());
        else if(view.getId()== R.id.dashboard_btn_logout)
            logoutUser();
    }

    private void logoutUser() {
        auth.signOut();
        if(auth.getCurrentUser() == null) {
            startActivity(new Intent(DashBoard.this,MainActivity.class));
            finish();
        }
    }

    private void changePassword(String newPassword, String renewPassword) {
        FirebaseUser user = auth.getCurrentUser();
        if(newPassword.equals(renewPassword)) {
            user.updatePassword(newPassword).addOnCompleteListener(this, new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        Snackbar snackbar = Snackbar.make(activity_dashboard, "Password Changed!", Snackbar.LENGTH_SHORT);
                        snackbar.show();
                    }
                }
            });
        }
        else
        {
            Toast.makeText(DashBoard.this,"Passwords didn't Match,Try Again!",Toast.LENGTH_SHORT).show();
            finish();
            startActivity(new Intent(DashBoard.this,DashBoard.class));
        }
    }
}