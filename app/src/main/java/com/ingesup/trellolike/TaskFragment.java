package com.ingesup.trellolike;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TaskFragment extends ListFragment {

    private List<Card> cards;
    private TaskAdapter adapter;
    private ListView cardListView;
    private View layout;
    private String key;
    private String token;
    private String boardId;

    public TaskFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("TASK", "CREATE FRAGMENT");
        SharedPreferences prefs = this.getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        TasksActivity tasksActivity = (TasksActivity)getActivity();
        boardId = prefs.getString("boardId", "");
        key = prefs.getString("trello_key", "");
        token = prefs.getString("trello_token", "");
        Log.d("TASKB", boardId);
        Log.d("TASKK", key);
        Log.d("TASKT", token);
        getCardsList();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task, container, false);
    }

    private void getCardsList() {
        try {
            TrelloAPIService service = TrelloAPIClient.getRetrofit().create(TrelloAPIService.class);
            Call<List<Card>> call = service.getCardsByBoardId(boardId, key, token);
            call.enqueue(new Callback<List<Card>>() {

                @Override
                public void onResponse(Call<List<Card>> call, Response<List<Card>> response) {
                    Log.d("RESPONSE", response.message());
                    cards = response.body();
                    adapter = new TaskAdapter(getActivity(), cards);
                    layout = (View) getView().findViewById(R.id.main_layout);
                    setListAdapter(adapter);
                }

                @Override
                public void onFailure(Call<List<Card>> call, Throwable t) {
                    Log.d("onFailure", t.getMessage());
                }
            });
        }catch (Exception e) {
            Log.d("MESSAGE", e.getMessage());
        }
    }

}