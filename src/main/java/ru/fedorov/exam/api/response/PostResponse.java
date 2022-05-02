package ru.fedorov.exam.api.response;
import lombok.Getter;
import lombok.Setter;
import ru.fedorov.exam.api.response.responseclasses.UserDTO;

@Getter
@Setter
public class PostResponse {
    private int count;
    private Post[] posts;

    public PostResponse() {
    }

    public PostResponse(Post[] posts) {
        this.count = posts.length;
        this.posts = posts;
    }

    @Setter
    @Getter
    public static class Post {
        private int id;
        private long timestamp;
        private String title;
        private String announce;
        private int likeCount;
        private int dislikeCount;
        private int commentCount;
        private int viewCount;
        private UserDTO user;
    }
}
