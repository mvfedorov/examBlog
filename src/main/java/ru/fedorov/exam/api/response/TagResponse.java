package ru.fedorov.exam.api.response;

import lombok.Getter;
import lombok.Setter;
import ru.fedorov.exam.api.response.responseclasses.TagDTO;
import ru.fedorov.exam.model.Tag;

@Getter
@Setter
public class TagResponse {
    private TagDTO[] tags;
}
