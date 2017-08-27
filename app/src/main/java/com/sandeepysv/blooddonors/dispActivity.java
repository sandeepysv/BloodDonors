package com.sandeepysv.blooddonors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

@SuppressWarnings("ALL")
public class dispActivity extends AppCompatActivity {

    /*private RecyclerView recyview;
    int length;
    private FirebaseDatabase database;
    private DatabaseReference databaseRef;
    Intent mIntent;
    String bloodgroup,splace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disp);

        database = FirebaseDatabase.getInstance();
        databaseRef = database.getReference();
        recyview = (RecyclerView)findViewById(R.id.recyclerView);
        recyview.setHasFixedSize(true);
        recyview.setLayoutManager(new LinearLayoutManager(this));

        mIntent = getIntent();
        bloodgroup = mIntent.getStringExtra("bloodgroup");
        splace = mIntent.getStringExtra("place");

        databaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                showdata(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void showdata(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            UserInformation uInfo = new UserInformation();
            long length;
            int i;
            ArrayList<String> array = new ArrayList<>();
            ArrayList<String> place = new ArrayList<>();
            ArrayAdapter adapter;
            length = ds.getChildrenCount();
            for(i=1;i<=length;++i) {
                uInfo.setName(ds.child(String.valueOf(i)).getValue(UserInformation.class).getName());
                uInfo.setPlace(ds.child(String.valueOf(i)).getValue(UserInformation.class).getPlace());
                uInfo.setBloodgroup(ds.child(String.valueOf(i)).getValue(UserInformation.class).getBloodgroup());
                uInfo.setLast(ds.child(String.valueOf(i)).getValue(UserInformation.class).getLast());
                uInfo.setPhone(ds.child(String.valueOf(i)).getValue(UserInformation.class).getPhone());

                if(bloodgroup != null)
                {if(splace != null) {
                    String gbg = uInfo.getBloodgroup();
                    String gsp = uInfo.getPlace();
                    if (gbg.equals(bloodgroup) && gsp.equalsIgnoreCase(splace)) {
                        array.add(uInfo.getName());
                        array.add(uInfo.getPlace());
                        place.add(uInfo.getPlace());
                        array.add(uInfo.getBloodgroup());
                        array.add(uInfo.getLast());
                        array.add(uInfo.getPhone());
                    }
                  }
                }
                else
                {
                    array.add(uInfo.getName());
                    array.add(uInfo.getPlace());
                    place.add(uInfo.getPlace());
                    array.add(uInfo.getBloodgroup());
                    array.add(uInfo.getLast());
                    array.add(uInfo.getPhone());
                }
                recyview.setAdapter(new MyAdapter(array,place));
            }
            if(i>length) {
                array.add("End of Data!");
                place.add("End of Data!");
            }
            recyview.setAdapter(new MyAdapter(array,place));
        }
    }*/

    private FirebaseDatabase database;
    private DatabaseReference databaseRef;

    DatabaseReference db;
    FirebaseHelper helper;
    CustomAdapter adapter;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disp);

        database = FirebaseDatabase.getInstance();
        databaseRef = database.getReference();

        lv = (ListView) findViewById(R.id.lv);

        db = FirebaseDatabase.getInstance().getReference();
        helper = new FirebaseHelper(db);
        //ADAPTER
        adapter = new CustomAdapter(this, helper.retrieve());
        lv.setAdapter(adapter);

    }
}