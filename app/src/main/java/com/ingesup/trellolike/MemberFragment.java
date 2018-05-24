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


public class MemberFragment extends ListFragment {

    private List<TrelloUser> members;
    private MemberAdapter adapter;
    private ListView memberListView;
    private View layout;
    private String key;
    private String token;
    private String boardId;

    public MemberFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("MEMBER", "CREATE FRAGMENT");
        SharedPreferences prefs = this.getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        boardId = prefs.getString("boardId", "");
        key = prefs.getString("trello_key", "");
        token = prefs.getString("trello_token", "");
        Log.d("TASKB", boardId);
        Log.d("TASKK", key);
        Log.d("TASKT", token);
        getMembersList();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task, container, false);
    }

    private void getMembersList() {
        try {
            TrelloAPIService service = TrelloAPIClient.getRetrofit().create(TrelloAPIService.class);
            Call<List<TrelloUser>> call = service.getMembersByBoardId(boardId, key, token);
            call.enqueue(new Callback<List<TrelloUser>>() {

                @Override
                public void onResponse(Call<List<TrelloUser>> call, Response<List<TrelloUser>> response) {
                    Log.d("RESPONSE", response.message());
                    members = response.body();
                    adapter = new MemberAdapter(getActivity(), members);
                    layout = (View) getView().findViewById(R.id.main_layout);
                    setListAdapter(adapter);
                }

                @Override
                public void onFailure(Call<List<TrelloUser>> call, Throwable t) {
                    Log.d("onFailure", t.getMessage());
                }
            });
        }catch (Exception e) {
            Log.d("MESSAGE", e.getMessage());
        }
    }

}