package com.ingesup.trellolike;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TrelloAPIService {

    // --- GET Methods --- //

    @GET("members/{username}")
    Call<TrelloUser> getMemberByUsername(@Path("username") String username);

    @GET("members/{username}/boards")
    Call<List<Board>> getBoardsByUsername(@Path("username") String username, @Query("key") String key, @Query("token") String token);

    @GET("boards/{id}/lists")
    Call<List<Column>> getListsByBoardId(@Path("id") String boardId, @Query("key") String key, @Query("token") String token);

    @GET("lists/{id}/cards")
    Call<List<Card>> getCardsByListId(@Path("id") String listId, @Query("key") String key, @Query("token") String token);

    @GET("boards/{id}/cards")
    Call<List<Card>> getCardsByBoardId(@Path("id") String boardId, @Query("key") String key, @Query("token") String token);

    @GET("boards/{id}/members")
    Call<List<TrelloUser>> getMembersByBoardId(@Path("id") String boardId, @Query("key") String key, @Query("token") String token);

    // --- POST Methods --- //




}
