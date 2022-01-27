package ru.fedorov.exam.service;

import org.springframework.stereotype.Service;
import ru.fedorov.exam.api.response.AuthCheckResponse;

@Service
public class AuthCheckService {
    public static AuthCheckResponse authCheck() {
        AuthCheckResponse authCheckResponse = new AuthCheckResponse();
        authCheckResponse.setResult(true);
        return authCheckResponse;
    }
}
