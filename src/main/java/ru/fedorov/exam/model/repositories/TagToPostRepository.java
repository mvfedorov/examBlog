package ru.fedorov.exam.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.fedorov.exam.api.response.responseclasses.TagDTO;
import ru.fedorov.exam.api.response.responseclasses.TagProjection;
import ru.fedorov.exam.model.TagToPost;

import java.util.List;

@Repository
public interface TagToPostRepository extends JpaRepository<TagToPost, Integer> {
    @Query("SELECT t.tag_id.name as name,count(t.post_id) as count from TagToPost t where name like :query group by t.tag_id.name")
    List<TagProjection> getPostsCountByTag(@Param("query") String query);
}
