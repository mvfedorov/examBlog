package ru.fedorov.exam.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tag2post")
public class TagToPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int post_id;
    private int tag_id;
}
