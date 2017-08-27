package com.sandeepysv.blooddonors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

@SuppressWarnings("ALL")
public class amActivity1 extends AppCompatActivity implements View.OnClickListener {

    Spinner spin;
    EditText id, name, place, last, ph;
    String sid, sname, splace, slast, sph;
    Button am, back;
    private FirebaseDatabase database;
    private DatabaseReference databaseRef;
    Object bloodgroup;
    public int starCount = 0;
    FirebaseHelper helper;
    CustomAdapter adapter;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_am1);

        database = FirebaseDatabase.getInstance();
        databaseRef = database.getReference();

        lv = (ListView) findViewById(R.id.lv);
        spin = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.blood_groups, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long sid) {
                bloodgroup = adapterView.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        id = (EditText)findViewById(R.id.edit1);
        name = (EditText)findViewById(R.id.edit2);
        place = (EditText)findViewById(R.id.edit3);
        last = (EditText)findViewById(R.id.edit4);
        ph = (EditText)findViewById(R.id.edit5);
        am = (Button)findViewById(R.id.btn_am);
        back = (Button)findViewById(R.id.btn_back);

        am.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        sid = id.getText().toString();
        sname = name.getText().toString();
        splace = place.getText().toString();
        slast = last.getText().toString();
        sph = ph.getText().toString();

        UserInformation u = new UserInformation();

        u.setId(sid);
        u.setName(sname);
        u.setPlace(splace);
        u.setPhone(sph);
        u.setBloodgroup((String)bloodgroup);
        u.setLast(slast);

        if(view.getId() == R.id.btn_am)
        {
            if(id.getText().toString().length() == 0 || name.getText().toString().length() == 0 || place.getText().toString().length() == 0 || last.getText().toString().length() == 0)
            {
                Toast.makeText(amActivity1.this,"Please Enter the Complete Details!",Toast.LENGTH_LONG).show();
            }
            else if(ph.getText().toString().length() < 10)
            {
                Toast.makeText(amActivity1.this,"Please Enter the Mobile No. Correctly!",Toast.LENGTH_LONG).show();
            }
            else
            {
                helper.save(u);
                Toast.makeText(amActivity1.this, "Saved!", Toast.LENGTH_LONG).show();

                /*if ()
                {
                    Toast.makeText(amActivity1.this, "Record Added/Modified Successfully!", Toast.LENGTH_LONG).show();
                    finish();
                    startActivity(new Intent(amActivity1.this, amActivity1.class));
                }
                else
                {
                    Toast.makeText(amActivity1.this, "Cannot Add/Modify!\nPlease Check your Internet Connection!", Toast.LENGTH_LONG).show();
                }*/
            }
        }

        if(view.getId() == R.id.btn_back)
        {
            finish();
        }
    }
}
