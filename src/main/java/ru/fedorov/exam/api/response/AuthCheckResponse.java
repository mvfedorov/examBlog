package ru.fedorov.exam.api.response;

import lombok.Getter;
import lombok.Setter;
import ru.fedorov.exam.model.User;

@Getter
@Setter
public class AuthCheckResponse {
    private User user;
    private boolean result;
}
