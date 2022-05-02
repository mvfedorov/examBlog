package ru.fedorov.exam.api.post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRegisterPost {
    private String e_mail;
    private String password;
    private String name;
    private String captcha;
    private String captcha_secret;

    public AuthRegisterPost(String e_mail, String password, String name, String captcha, String captcha_secret) {
        this.e_mail = e_mail;
        this.password = password;
        this.name = name;
        this.captcha = captcha;
        this.captcha_secret = captcha_secret;
    }
}
