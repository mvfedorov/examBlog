package ru.fedorov.exam.service;

import ru.fedorov.exam.api.response.CalendarResponse;
import ru.fedorov.exam.api.response.PostByIdResponse;
import ru.fedorov.exam.api.response.PostResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface PostService {
    public PostResponse getPosts(int offset, int limit, String mode);
    public PostResponse searchPosts(int offset, int limit, String query);
    public CalendarResponse postsCalendar(Integer year);
    public PostResponse postByDate(int offset, int limit, LocalDate date);
    public PostResponse postByTag(int offset, int limit, String tag);
    public PostByIdResponse postById(int id);
    public PostResponse postForModeration(int offset, int limit, String status);
}
