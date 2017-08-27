package com.sandeepysv.blooddonors;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import br.com.bloder.magic.view.MagicButton;

@SuppressWarnings("ALL")
public class UserBoard extends AppCompatActivity {

    boolean twice;
    private FirebaseAuth auth;
    private TextView txtWelcome;
    MagicButton bAM,bSearch,bDisp,bExit;
    String uname;

    @Override
    public void onBackPressed()
    {
        if(twice == true)
        {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
            System.exit(0);
        }
        twice = true;
        //super.onBackPressed();

        Toast.makeText(UserBoard.this,"Press BACK again to Exit",Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                twice = false;
            }
        },3000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_board);

        auth = FirebaseAuth.getInstance();
        bAM = (MagicButton)findViewById(R.id.usr_am);
        bSearch = (MagicButton)findViewById(R.id.usr_search);
        bDisp = (MagicButton)findViewById(R.id.usr_disp);
        bExit = (MagicButton)findViewById(R.id.usr_exit);

        txtWelcome = (TextView)findViewById(R.id.usr_welcome);

        if(auth.getCurrentUser() != null) {
            uname = auth.getCurrentUser().getEmail();
            txtWelcome.setText("Welcome,\n"+uname+"!");
        }

        bAM.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 startActivity(new Intent(UserBoard.this,amActivity1.class));
            }
        });

        bSearch.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserBoard.this,searchActivity.class));
            }
        });

        bDisp.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UserBoard.this,"Please Wait while we Fetch the Data!",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(UserBoard.this,dispActivity.class));
            }
        });

        bExit.setMagicButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UserBoard.this,"Logged Out Successfully!",Toast.LENGTH_SHORT).show();
                auth.signOut();
                if(auth.getCurrentUser() == null)
                {
                    startActivity(new Intent(UserBoard.this,ThankYou.class));
                    finish();
                }
            }
        });
    }
}