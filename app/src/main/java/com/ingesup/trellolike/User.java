package com.ingesup.trellolike;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class User {

    public String username;
    public String email;
    public String key;
    public String token;

    public User() {

    }

    public User(String username, String key, String token) {
        this.username = username;
        this.key = key;
        this.token = token;
    }

    public User(String username, String email, String key, String token) {
        this.username = username;
        this.email = email;
        this.key = key;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("username", username);
        result.put("key", key);
        result.put("token", token);

        return result;
    }
}
