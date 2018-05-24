package com.ingesup.trellolike;

import java.util.LinkedList;

public class Card extends TrelloAuth{
    private String id;
    private String desc;
    private String idBoard;
    private String idList;
    private String name;
    private Double pos;
    private LinkedList<Member> members;

    public Card(String key, String token, String name, String desc, String idList, Double pos) {
        super(key, token);
        this.name = name;
        this.desc = desc;
        this.idList = idList;
        this.pos = pos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getIdBoard() {
        return idBoard;
    }

    public void setIdBoard(String idBoard) {
        this.idBoard = idBoard;
    }

    public String getIdList() {
        return idList;
    }

    public void setIdList(String idList) {
        this.idList = idList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPos() {
        return pos;
    }

    public void setPos(Double pos) {
        this.pos = pos;
    }

    public LinkedList<Member> getMembers() {
        return members;
    }

    public void setMembers(LinkedList<Member> members) {
        this.members = members;
    }
}
