package ru.fedorov.exam.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.fedorov.exam.enums.ModerationStatus;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posts")
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private boolean isActive;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ModerationStatus moderationStatus;
    private int moderatorId;
    @Column(nullable = false)
    private int userId;
    @Column(nullable = false)
    private Date time;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String text;
    @Column(nullable = false)
    private int viewCount;
}
