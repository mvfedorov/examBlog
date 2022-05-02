package ru.fedorov.exam.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.Query;
import ru.fedorov.exam.model.enums.ModerationStatus;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

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
    @ManyToOne
    @JoinColumn(name = "moderator_id")
    private User moderator;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(nullable = false)
    private Date time;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false,columnDefinition = "TEXT")
    private String text;
    @Column(nullable = false)
    private int viewCount;
    @OneToMany(mappedBy = "post")
    Set<PostComment> postComments;
    @OneToMany(mappedBy = "post_id")
    Set<PostVote> postVotes;

    public int getLikeCount() {
        return (int) postVotes.stream().filter(pv -> pv.getValue() == 1).count();
    }

    public int getDislikeCount() {
        return (int) postVotes.stream().filter(pv -> pv.getValue() == -1).count();
    }

    public int getCommentCount() {
        return postComments.size();
    }
}
