package ru.fedorov.exam.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fedorov.exam.api.post.AuthRegisterPost;
import ru.fedorov.exam.api.response.AuthCheckResponse;
import ru.fedorov.exam.api.response.CaptchaResponse;
import ru.fedorov.exam.api.response.RegisterResponse;
import ru.fedorov.exam.service.AuthCheckService;

@RestController
@RequestMapping("/api/auth")
public class ApiAuthController {
    private final AuthCheckService authCheckService;

    public ApiAuthController(AuthCheckService authCheckServiceImpl) {
        this.authCheckService = authCheckServiceImpl;
    }

    //TODO complete all methods
    @GetMapping("/check")
    private ResponseEntity<AuthCheckResponse> authCheck() {
        System.out.println("Check");
        return new ResponseEntity<>(authCheckService.authCheck(), HttpStatus.OK);
    }

    @GetMapping("/captcha")
    private ResponseEntity<CaptchaResponse> authCaptcha() {
        return new ResponseEntity<>(authCheckService.authCaptcha(), HttpStatus.OK);
    }

    @PostMapping("/register")
    private ResponseEntity<RegisterResponse> authRegister(AuthRegisterPost authRegisterPost) {
        return new ResponseEntity<>(authCheckService.register(authRegisterPost), HttpStatus.OK);
    }
}
