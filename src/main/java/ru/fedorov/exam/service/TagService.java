package ru.fedorov.exam.service;

import ru.fedorov.exam.api.response.TagResponse;

public interface TagService {
    public TagResponse getTags(String query);
}
