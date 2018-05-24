package com.ingesup.trellolike;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.Date;

@Table(name = "Message")
public class Message extends Model{

    @Column(name = "id")
    private Integer id;

    @Column(name = "content")
    private String content;

    @Column(name = "userId")
    private String userId;

    @Column(name = "boardId")
    private String boardId;

    @Column(name = "date")
    private Date date;

}
