package ru.fedorov.exam.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "post_comments")
@Getter
@Setter
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id_id")
    private PostComment parentId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id_id", nullable = false)
    private Post postId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id_id", nullable = false)
    private User userId;
    @Column(nullable = false)
    private Date time;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String text;
}
