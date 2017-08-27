package com.sandeepysv.blooddonors;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

@SuppressWarnings("ALL")
class FirebaseHelper {
    private ArrayList<UserInformation> uInfos = new ArrayList<>();
    private Boolean saved = false;
    //private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseRef; //= database.getReference();

    FirebaseHelper(DatabaseReference db)
    {
        this.databaseRef=db;
    }

    public boolean save(UserInformation uInfo)
    {
        if(uInfo == null)
        {
            saved = false;
        }
        else
        {
            try
            {
                //databaseRef.child("Users").push().setValue(uInfo);
                //databaseRef.child("Users").child(uInfo.toString()).child("id").setValue(uInfo.getId());
                saved = true;
            }
            catch (Exception db)
            {
                db.printStackTrace();
                saved = false;
            }
        }

        return saved;

    }

    private void fetchData(DataSnapshot dataSnapshot) {
        uInfos.clear();
        for (DataSnapshot ds : dataSnapshot.getChildren()) {
            UserInformation userInformation = ds.getValue(UserInformation.class);
            uInfos.add(userInformation);
        }
    }

    public ArrayList<UserInformation> retrieve() {

        databaseRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return uInfos;

    }

}