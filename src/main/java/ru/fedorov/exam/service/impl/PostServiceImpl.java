package ru.fedorov.exam.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fedorov.exam.api.response.CalendarResponse;
import ru.fedorov.exam.api.response.PostByIdResponse;
import ru.fedorov.exam.api.response.PostResponse;
import ru.fedorov.exam.api.response.responseclasses.CalendarProjection;
import ru.fedorov.exam.mapping.MappingUtils;
import ru.fedorov.exam.model.Post;
import ru.fedorov.exam.model.repositories.PostRepository;
import ru.fedorov.exam.service.PostService;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    //TODO make filter by active, mod_status, date before now
    @Override
    @Transactional
    public PostResponse getPosts(int offset, int limit, String mode) {

        Page<Post> postPage;
        PageRequest pageRequest = PageRequest.of(offset, limit);

        switch (mode) {
            case "recent" :
                postPage = postRepository.findPostsOrderByDateDesc(pageRequest);
                break;
            case "popular" :
                postPage = postRepository.findPostsOrderByComments(pageRequest);
                break;
            case "best" :
                postPage = postRepository.findPostsOrderByLikes(pageRequest);
                break;
            case "early" :
                postPage = postRepository.findPostsOrderByDateAsc(pageRequest);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + mode);
        }

        PostResponse.Post[] posts = postPage.stream().map(MappingUtils::postToPostDTO).toArray(PostResponse.Post[]::new);
        PostResponse postResponse = new PostResponse(posts);

        return postResponse;
    }

    @Override
    @Transactional
    public PostResponse searchPosts(int offset, int limit, String query) {

        PageRequest pageRequest = PageRequest.of(offset, limit);
        Page<Post> postPage;

        if (query.isBlank()) {
            postPage = postRepository.findPostsByQuery(query, pageRequest);
        } else {
            postPage = postRepository.findPostsOrderByDateDesc(pageRequest);
        }

        PostResponse.Post[] posts = postPage.stream().map(MappingUtils::postToPostDTO).toArray(PostResponse.Post[]::new);
        PostResponse postResponse = new PostResponse(posts);

        return postResponse;
    }

    @Override
    @Transactional
    public CalendarResponse postsCalendar(Integer year) {

        CalendarResponse postByYearResponse = new CalendarResponse();
        List<CalendarProjection> calendarProjectionList = postRepository.calendarPost(year == null ? LocalDate.now().getYear() : year);

        // example of using stream & groupingBy
        Map<String, Integer> posts = calendarProjectionList.stream().collect(
                Collectors.groupingBy(s -> s.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                Collectors.summingInt(CalendarProjection::getPostCount)));

        //Map<String, Integer> posts = new TreeMap<>();
        //for (CalendarProjection c: calendarProjectionList) {
        //    posts.put(String.valueOf(c.getDate().getYear()), c.getPostCount());
        //}

        // TODO complete years get
        postByYearResponse.setYears(postRepository.getPostsYears());

        postByYearResponse.setPosts(posts);
        return postByYearResponse;
    }

    @Override
    @Transactional
    public PostResponse postByDate(int offset, int limit, LocalDate date) {
        PageRequest pageRequest = PageRequest.of(offset, limit);
        Page<Post> postPage;

        Date startDate = Date.from(date.atTime(LocalTime.MIDNIGHT).toInstant(ZoneOffset.UTC));
        Date endDate = Date.from(date.atTime(LocalTime.MAX).toInstant(ZoneOffset.UTC));

        postPage = postRepository.findPostsByDate(startDate,endDate, pageRequest);

        PostResponse.Post[] posts = postPage.stream().map(MappingUtils::postToPostDTO).toArray(PostResponse.Post[]::new);
        PostResponse postResponse = new PostResponse(posts);

        return postResponse;
    }

    @Override
    @Transactional
    public PostResponse postByTag(int offset, int limit, String tag) {
        PageRequest pageRequest = PageRequest.of(offset, limit);
        Page<Post> postPage;

        postPage = postRepository.findPostsByTag(tag, pageRequest);

        PostResponse.Post[] posts = postPage.stream().map(MappingUtils::postToPostDTO).toArray(PostResponse.Post[]::new);
        PostResponse postResponse = new PostResponse(posts);

        return postResponse;
    }

    @Override
    @Transactional
    public PostByIdResponse postById(int id) {

        Post post = postRepository.findById(id).orElse(null);

        if (post != null) {
            post.setViewCount(post.getViewCount() + 1);
        }

        postRepository.save(post);

        return MappingUtils.postToPostByIdResponse(post);
    }

    @Override
    @Transactional
    public PostResponse postForModeration(int offset, int limit, String status) {
        return null;
    }
}
