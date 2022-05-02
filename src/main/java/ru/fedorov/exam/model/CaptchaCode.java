package ru.fedorov.exam.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private LocalDateTime time;
    @Column(nullable = false, columnDefinition = "TINYTEXT")
    private String code;
    @Column(nullable = false, columnDefinition = "TINYTEXT")
    private String secretCode;
}
