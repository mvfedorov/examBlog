package ru.fedorov.exam.service.impl;

import com.github.cage.Cage;
import com.github.cage.GCage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fedorov.exam.api.post.AuthRegisterPost;
import ru.fedorov.exam.api.response.AuthCheckResponse;
import ru.fedorov.exam.api.response.CaptchaResponse;
import ru.fedorov.exam.api.response.RegisterResponse;
import ru.fedorov.exam.model.CaptchaCode;
import ru.fedorov.exam.model.repositories.CaptchaRepository;
import ru.fedorov.exam.service.AuthCheckService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.UUID;

@Service
public class AuthCheckServiceImpl implements AuthCheckService {
    CaptchaRepository captchaRepository;

    public AuthCheckServiceImpl(CaptchaRepository captchaRepository) {
        this.captchaRepository = captchaRepository;
    }

    @Override
    public AuthCheckResponse authCheck() {
        AuthCheckResponse authCheckResponse = new AuthCheckResponse();
        authCheckResponse.setResult(false);
        return authCheckResponse;
    }

    @Override
    @Transactional
    public CaptchaResponse authCaptcha() {

        // Captcha Cage
        Cage cage = new GCage();
        String captchaText = cage.getTokenGenerator().next();
        UUID captchaKey = UUID.randomUUID();

        // Image output
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            cage.draw(captchaText,os);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // CaptchaCode save to DB
        CaptchaCode captchaCode = new CaptchaCode();
        captchaCode.setCode(captchaText);
        captchaCode.setSecretCode(captchaKey.toString());
        var addPeriod = LocalDateTime.now().plus(1,ChronoUnit.HOURS);
        //captchaCode.setTime(Date.from(addPeriod.toInstant(ZoneId.systemDefault())));
        captchaCode.setTime(addPeriod);
        captchaRepository.save(captchaCode);

        // Captcha response
        CaptchaResponse captchaResponse = new CaptchaResponse();
        captchaResponse.setSecret(captchaKey.toString());
        captchaResponse.setImage("data:image/png;base64, " + Base64.getEncoder().encodeToString(os.toByteArray()));

        return captchaResponse;
    }

    @Override
    public RegisterResponse register(AuthRegisterPost authRegisterPost) {
        // TODO complete registration checking
        RegisterResponse response = new RegisterResponse();
        response.setResult(true);
        return response;
    }
}
