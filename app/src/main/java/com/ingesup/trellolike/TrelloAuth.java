package com.ingesup.trellolike;

public class TrelloAuth {
    private String key;
    private String token;

    public TrelloAuth(String key, String token) {
        super();
        this.key = key;
        this.token = token;
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
}
