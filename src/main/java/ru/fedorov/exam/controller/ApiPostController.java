package ru.fedorov.exam.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.fedorov.exam.api.response.PostByIdResponse;
import ru.fedorov.exam.api.response.PostResponse;
import ru.fedorov.exam.service.PostService;
import ru.fedorov.exam.service.impl.PostServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequestMapping("/api/post")
public class ApiPostController {
    private final PostService postService;

    public ApiPostController(PostServiceImpl postService) {
        this.postService = postService;
    }

    // TODO: 16.03.22 check all return status
    @GetMapping("")
    private ResponseEntity<PostResponse> post(@RequestParam(value = "offset", required = false) int offset,
                                              @RequestParam(value = "limit", required = false) int limit,
                                              @RequestParam(value = "mode", required = false) String mode) {
        if (limit == 0) { limit = 10; }
        if (mode == null) { mode = "recent"; }
        return new ResponseEntity<>(postService.getPosts(offset, limit, mode), HttpStatus.OK);
    }

    @GetMapping("/search")
    private ResponseEntity<PostResponse> postSearch(@RequestParam("offset") int offset,
                                                          @RequestParam("limit") int limit,
                                                          @RequestParam("query") String query) {
        return new ResponseEntity<>(postService.searchPosts(offset, limit, query),HttpStatus.OK);
    }

    @GetMapping("/byDate")
    private ResponseEntity<PostResponse> postByDate(@RequestParam("offset") int offset,
                                                    @RequestParam("limit") int limit,
                                                    @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return new ResponseEntity<>(postService.postByDate(offset, limit, date),HttpStatus.OK);
    }

    @GetMapping("/byTag")
    private ResponseEntity<PostResponse> postByTag(@RequestParam("offset") int offset,
                                                   @RequestParam("limit") int limit,
                                                   @RequestParam("tag") String tag) {
        return new ResponseEntity<>(postService.postByTag(offset,limit,tag),HttpStatus.OK);
    }

    @GetMapping("/{ID}")
    private ResponseEntity<PostByIdResponse> postById(@PathVariable("ID") int id) {
        return new ResponseEntity<>(postService.postById(id),HttpStatus.OK);
    }

    @GetMapping("/moderation")
    private ResponseEntity<PostResponse> postModeration(@RequestParam("offset") int offset,
                                                   @RequestParam("limit") int limit,
                                                   @RequestParam("status") String status) {
        return new ResponseEntity<>(postService.postForModeration(offset,limit,status),HttpStatus.OK);
    }
}
