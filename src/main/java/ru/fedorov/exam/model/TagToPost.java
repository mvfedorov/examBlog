package ru.fedorov.exam.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tag2post")
@Getter
@Setter
public class TagToPost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id_id", nullable = false)
    private Post post_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id_id", nullable = false)
    private Tag tag_id;
}
