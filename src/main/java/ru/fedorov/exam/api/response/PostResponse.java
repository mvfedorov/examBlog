package ru.fedorov.exam.api.response;
import lombok.Getter;
import lombok.Setter;
import ru.fedorov.exam.model.Post;

@Getter
@Setter
public class PostResponse {
    private int count;
    private Post[] posts;
}
