package ru.fedorov.exam.api.response;

import lombok.Getter;
import lombok.Setter;
import ru.fedorov.exam.api.response.responseclasses.PostCommentDTO;
import ru.fedorov.exam.api.response.responseclasses.UserDTO;

@Setter
@Getter
public class PostByIdResponse {
    private int id;
    private long timestamp;
    private boolean active;
    private UserDTO user;
    private String title;
    private String text;
    private int likeCount;
    private int dislikeCount;
    private int viewCount;
    private PostCommentDTO[] comments;
}
