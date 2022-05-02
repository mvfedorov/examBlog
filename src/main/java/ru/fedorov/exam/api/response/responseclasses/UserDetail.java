package ru.fedorov.exam.api.response.responseclasses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDetail {
    private int id;
    private String name;
    private String photo;
    private String email;
    private String moderation;
    private int moderationCount;
    private boolean settings;
}
