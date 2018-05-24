package com.ingesup.trellolike;

public class TrelloUser extends TrelloAuth{
    private String fullName;
    private String username;

    public TrelloUser(String key, String token, String fullName, String username) {
        super(key, token);
        this.fullName = fullName;
        this.username = username;
    }

    public String getFullname() {
        return fullName;
    }

    public void setFullname(String fullname) {
        this.fullName = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
