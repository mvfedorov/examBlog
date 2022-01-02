package ru.fedorov.exam.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "post_comments")
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int parentId;
    private int postId;
    private int userId;
    private Date time;
    private String text;
}
