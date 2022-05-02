package ru.fedorov.exam.api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterResponse {
    private boolean result;
    private Errors errors;

    @Getter
    @Setter
    public static class Errors {
        private String email;
        private String name;
        private String password;
        private String captcha;
    }
}
