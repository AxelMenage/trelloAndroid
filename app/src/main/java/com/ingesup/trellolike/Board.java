package com.ingesup.trellolike;

import java.util.LinkedList;

public class Board extends TrelloAuth{

    private String id;
    private String name;
    private String desc;
    private Integer nbMembers;
    private LinkedList<Column> lists;

    public Board(String key, String token, String name, String desc) {
        super(key, token);
        this.name = name;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public Integer getNbMembers() {
        return nbMembers;
    }

    public LinkedList<Column> getLists() {
        return lists;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setNbMembers(Integer nbMembers) {
        this.nbMembers = nbMembers;
    }

    public void setLists(LinkedList<Column> lists) {
        this.lists = lists;
    }
}
