package ru.fedorov.exam.service;

import org.springframework.stereotype.Service;
import ru.fedorov.exam.api.response.PostResponse;
import ru.fedorov.exam.model.Post;

@Service
public class PostService {
    public static PostResponse getPosts() {
        PostResponse postResponse = new PostResponse();
        postResponse.setCount(0);
        Post[] posts = {};
        postResponse.setPosts(posts);
        return postResponse;
    }
}
