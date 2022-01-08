package ru.fedorov.exam.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "captcha_codes")
@Getter
@Setter
public class CaptchaCode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private Date time;
    @Column(nullable = false, columnDefinition = "TINYTEXT")
    private int code;
    @Column(nullable = false, columnDefinition = "TINYTEXT")
    private int secretCode;
}
