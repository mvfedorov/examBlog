package ru.fedorov.exam.service;

import ru.fedorov.exam.api.post.AuthRegisterPost;
import ru.fedorov.exam.api.response.AuthCheckResponse;
import ru.fedorov.exam.api.response.CaptchaResponse;
import ru.fedorov.exam.api.response.RegisterResponse;

public interface AuthCheckService {
    public AuthCheckResponse authCheck();
    public CaptchaResponse authCaptcha();
    public RegisterResponse register(AuthRegisterPost authRegisterPost);
}
