package ru.fedorov.exam.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fedorov.exam.api.response.TagResponse;
import ru.fedorov.exam.api.response.responseclasses.TagDTO;
import ru.fedorov.exam.api.response.responseclasses.TagProjection;
import ru.fedorov.exam.model.repositories.TagToPostRepository;
import ru.fedorov.exam.service.TagService;

import java.util.Comparator;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    TagToPostRepository tagToPostRepository;

    public TagServiceImpl(TagToPostRepository tagToPostRepository) {
        this.tagToPostRepository = tagToPostRepository;
    }

    @Override
    @Transactional
    public TagResponse getTags(String query) {

        List<TagProjection> tagProjections = tagToPostRepository.getPostsCountByTag(query + "%");

        Long maxCount = tagProjections.stream()
                .map(t -> t.getCount())
                .max(Long::compare).orElse(1L);

        if (maxCount == 0) { maxCount = 1L;}

        final Long maxCountFinal = maxCount;

        TagDTO[] tagDTO = tagProjections.stream()
                .map(t -> new TagDTO(t.getName(),((double) t.getCount()/maxCountFinal)))
                .toArray(TagDTO[]::new);
        //tagResponse.setTags(tagDTOList.toArray(TagDTO[]::new));

        TagResponse tagResponse = new TagResponse();
        tagResponse.setTags(tagDTO);

        return tagResponse;
    }
}
