package ru.fedorov.exam.api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRegisterResponse {
    private boolean result;
    private ErrorResponse errors;

    // TODO make other classes like this
    private class ErrorResponse {
        private String email;
        private String name;
        private String password;
        private String captcha;
    }
}
