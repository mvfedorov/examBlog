package ru.fedorov.exam.api.response;

import lombok.Getter;
import lombok.Setter;
import ru.fedorov.exam.api.response.responseclasses.UserDetail;
import ru.fedorov.exam.model.User;

@Getter
@Setter
public class AuthCheckResponse {
    private UserDetail user;
    private boolean result;
}
