package com.sandeepysv.blooddonors;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThankYou extends AppCompatActivity implements View.OnClickListener {

    Button bSignIn;
    boolean twice;

    @Override
    public void onBackPressed() {

        if(twice)
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
        Toast.makeText(ThankYou.this,"Press BACK again to Exit",Toast.LENGTH_SHORT).show();
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
        setContentView(R.layout.activity_thank_you);

        bSignIn = (Button)findViewById(R.id.bSignIn);
        bSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.bSignIn) {
            startActivity(new Intent(ThankYou.this,MainActivity.class));
            finish();
        }
    }
}
