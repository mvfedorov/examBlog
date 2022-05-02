package ru.fedorov.exam.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fedorov.exam.api.response.*;
import ru.fedorov.exam.service.AuthCheckService;
import ru.fedorov.exam.service.PostService;
import ru.fedorov.exam.service.SettingsService;
import ru.fedorov.exam.service.TagService;
import ru.fedorov.exam.service.impl.TagServiceImpl;

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
        return new ResponseEntity<>(settingsService.getGlobalSettings(),HttpStatus.OK);
    }

    @GetMapping("/tag")
    private ResponseEntity<TagResponse> tags(@RequestParam(value = "query", required = false) String query) {
        return new ResponseEntity<>(tagService.getTags(query),HttpStatus.OK);
    }

    @GetMapping("/calendar")
    private ResponseEntity<CalendarResponse> getPostsInYear(@RequestParam(value = "year", required = false) Integer year) {
        return new ResponseEntity<>(postService.postsCalendar(year),HttpStatus.OK);
    }
}
