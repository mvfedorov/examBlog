package ru.fedorov.exam.api.response.responseclasses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostCommentDTO {
    private int id;
    private long timestamp;
    private String text;
    private UserWithPhoto user;
}
