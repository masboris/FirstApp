package com.example.sqlite.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.sqlite.R;
import com.example.sqlite.entity.User;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    Context c;
    List<User> users;

    public MyAdapter(Context c, List<User> users) {
        this.c = c;
        this.users = users;
    }


    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v;
        if (view == null) {
            v = View.inflate(c, R.layout.showitem, null);
        } else {
            v = view;
        }

        User user = users.get(i);

        TextView s0 = v.findViewById(R.id.s0);
        TextView s1 = v.findViewById(R.id.s1);
        TextView s2 = v.findViewById(R.id.s2);
        TextView s3 = v.findViewById(R.id.s3);

        s0.setText(""+user.get_id());
        s1.setText(user.getUsername());
        s2.setText(user.getUserpass());
        s3.setText(""+user.getAge());

        return v;
    }
}