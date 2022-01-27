package ru.fedorov.exam.service;

import org.springframework.stereotype.Service;
import ru.fedorov.exam.api.response.TagResponse;
import ru.fedorov.exam.model.Tag;

@Service
public class TagService {
    public static TagResponse getTags() {
        TagResponse tagResponse = new TagResponse();
        tagResponse.setTags(new Tag[0]);
        return tagResponse;
    }
}
