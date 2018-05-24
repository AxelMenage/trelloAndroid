package com.ingesup.trellolike;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MemberAdapter extends ArrayAdapter<TrelloUser> {

    private int LAYOUT_RESOURCE_ID = R.layout.item_member;
    private List<TrelloUser> members;

    public MemberAdapter(Context context, List<TrelloUser> objects) {
        super(context, 0, objects);
        members = objects;
        Log.d("MEMBERS", String.valueOf(members.size()));
    }

    @Override
    public int getCount() {
        return members.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(LAYOUT_RESOURCE_ID, null);
        }

        TextView item_member = (TextView) convertView.findViewById(R.id.item_member);

        TrelloUser currentItem = members.get(position);
        item_member.setText(currentItem.getFullname());

        return convertView;
    }
}
