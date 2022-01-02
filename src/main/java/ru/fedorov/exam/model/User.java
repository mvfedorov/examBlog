package ru.fedorov.exam.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int isModerator;
    private Date regTime;
    private String name;
    private String email;
    private String password;
    private String code;
    private String photo;

}
