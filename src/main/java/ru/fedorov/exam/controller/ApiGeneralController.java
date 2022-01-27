package ru.fedorov.exam.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fedorov.exam.api.response.*;
import ru.fedorov.exam.service.AuthCheckService;
import ru.fedorov.exam.service.PostService;
import ru.fedorov.exam.service.SettingsService;
import ru.fedorov.exam.service.TagService;

@RestController
@RequestMapping("/api")
public class ApiGeneralController {
    private final InitResponse initResponse;
    private final SettingsService settingsService;
    private final AuthCheckService authCheckService;
    private final PostService postService;
    private final TagService tagService;

    public ApiGeneralController(InitResponse initResponse, SettingsService settingsService, AuthCheckService authCheckService, PostService postService, TagService tagService) {
        this.initResponse = initResponse;
        this.settingsService = settingsService;
        this.authCheckService = authCheckService;
        this.postService = postService;
        this.tagService = tagService;
    }

    @GetMapping("/init")
    private ResponseEntity<InitResponse> init() {
        return new ResponseEntity<>(initResponse, HttpStatus.OK);
    }

    @GetMapping("/settings")
    private ResponseEntity<SettingsResponse> settings() {
        return new ResponseEntity<>(SettingsService.getGlobalSettings(),HttpStatus.OK);
    }

    @GetMapping("/auth/check")
    private ResponseEntity<AuthCheckResponse> authCheck() {
        return new ResponseEntity<>(AuthCheckService.authCheck(),HttpStatus.OK);
    }

    @GetMapping("/post")
    private ResponseEntity<PostResponse> post() {
        return new ResponseEntity<>(PostService.getPosts(),HttpStatus.OK);
    }

    @GetMapping("/tag")
    private ResponseEntity<TagResponse> tags() {
        return new ResponseEntity<>(TagService.getTags(),HttpStatus.OK);
    }

}
