package com.ingesup.trellolike;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class TaskAdapter extends ArrayAdapter<Card> {

    private int LAYOUT_RESOURCE_ID = R.layout.item_card;
    private List<Card> tasks;

    public TaskAdapter(Context context, List<Card> objects) {
        super(context, 0, objects);
        tasks = objects;
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(LAYOUT_RESOURCE_ID, null);
        }

        TextView item_card = (TextView) convertView.findViewById(R.id.item_card);

        Card currentItem = tasks.get(position);
        item_card.setText(currentItem.getName());

        return convertView;
    }
}
