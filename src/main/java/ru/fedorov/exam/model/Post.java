package ru.fedorov.exam.model;

import lombok.Data;
import ru.fedorov.exam.enums.ModerationStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int isActive;
    private ModerationStatus moderationStatus;
    private int moderatorId;
    private int userId;
    private Date time;
    private String title;
    private String text;
    private int viewCount;
}
