package com.sandeepysv.blooddonors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class searchActivity extends AppCompatActivity implements View.OnClickListener {

    Spinner spin;
    EditText splace;
    String bloodgroup,place;
    Button search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        spin = (Spinner)findViewById(R.id.spinner);
        splace = (EditText)findViewById(R.id.splace);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.blood_groups,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);

        search = (Button)findViewById(R.id.bSearch);
        search.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.bSearch)
        {
            bloodgroup = String.valueOf(spin.getSelectedItem());
            place = splace.getText().toString();
            if(splace.getText().toString().length() == 0)
                Toast.makeText(searchActivity.this,"Please Enter the Complete Details!",Toast.LENGTH_LONG).show();
            Toast.makeText(searchActivity.this,"Please Wait while we get the Info!",Toast.LENGTH_SHORT).show();
            Intent myintent = new Intent(searchActivity.this, dispActivity.class);
            myintent.putExtra("bloodgroup", bloodgroup);
            myintent.putExtra("place",place);
            startActivity(myintent);
        }
    }
}
