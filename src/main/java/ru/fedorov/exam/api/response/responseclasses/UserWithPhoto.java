package ru.fedorov.exam.api.response.responseclasses;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserWithPhoto {
    private int id;
    private String name;
    private String photo;
}
