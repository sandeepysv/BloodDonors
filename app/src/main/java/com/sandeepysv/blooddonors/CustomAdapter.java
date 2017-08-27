package com.sandeepysv.blooddonors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter{

    private Context c;
    private ArrayList<UserInformation> uInfos;

    public CustomAdapter(Context c, ArrayList<UserInformation> uInfos) {
        this.c = c;
        this.uInfos = uInfos;
    }

    @Override
    public int getCount() {
        return uInfos.size();
    }

    @Override
    public Object getItem(int i) {
        return uInfos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
        {
            view = LayoutInflater.from(c).inflate(R.layout.list_item,viewGroup,false);
        }

        TextView name = (TextView)view.findViewById(R.id.nameTxt);
        TextView place = (TextView)view.findViewById(R.id.placeTxt);
        TextView bloodgroup = (TextView)view.findViewById(R.id.bloodgroupTxt);
        TextView last = (TextView)view.findViewById(R.id.lastTxt);
        TextView phone = (TextView)view.findViewById(R.id.phoneTxt);

        final UserInformation u = (UserInformation)this.getItem(i);

        name.setText(u.getName());
        place.setText(u.getPlace());
        bloodgroup.setText(u.getBloodgroup());
        last.setText(u.getLast());
        phone.setText(u.getPhone());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(c,u.getPlace(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;

    }
}
