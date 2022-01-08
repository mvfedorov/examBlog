package ru.fedorov.exam.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private boolean isModerator;
    @Column(nullable = false)
    private Date regTime;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private String code;
    @Column(columnDefinition = "TEXT")
    private String photo;
}
