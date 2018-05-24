package com.ingesup.trellolike;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class BoardAdapter extends ArrayAdapter<Board> {

    private int LAYOUT_RESOURCE_ID = R.layout.item_board;
    private List<Board> boards;

    public BoardAdapter(Context context, List<Board> objects) {
        super(context, 0, objects);
        boards = objects;
        Log.w("BOARDS:", String.valueOf(boards.size()));
    }

    @Override
    public int getCount() {
        return boards.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(LAYOUT_RESOURCE_ID, null);
        }

        TextView item_board = (TextView) convertView.findViewById(R.id.item_board);

        Board currentItem = boards.get(position);
        item_board.setText(currentItem.getName());

        return convertView;
    }
}
