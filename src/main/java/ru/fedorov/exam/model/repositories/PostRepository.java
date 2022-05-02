package ru.fedorov.exam.model.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.fedorov.exam.api.response.responseclasses.CalendarProjection;
import ru.fedorov.exam.model.Post;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    // TODO check all queries
    @Query("select p " +
            "from Post p " +
            "left join PostVote pv " +
                "on p.id = pv.post_id.id " +
                "and p.isActive = true " +
                "and p.moderationStatus = 'ACCEPTED'" +
                "and pv.value = 1 " +
                "and p.time <= CURRENT_DATE " +
            "group by p order by count(pv.id)")
    Page<Post> findPostsOrderByLikes(Pageable pageRequest);

    @Query("select p " +
            "from Post p " +
            "left join PostComment pc " +
            "on p.id = pc.post.id " +
            "and p.isActive = true " +
            "and p.moderationStatus = 'ACCEPTED'" +
            "and p.time <= CURRENT_DATE " +
            "group by p order by count(pc.id)")
    Page<Post> findPostsOrderByComments(Pageable pageRequest);

    @Query("select p " +
            "from Post p " +
            "where p.isActive = true " +
            "and p.moderationStatus = 'ACCEPTED'" +
            "and p.time <= CURRENT_DATE " +
            "order by p.time desc")
    Page<Post> findPostsOrderByDateDesc(Pageable pageRequest);

    @Query("select p " +
            "from Post p " +
            "where p.isActive = true " +
            "and p.moderationStatus = 'ACCEPTED'" +
            "and p.time <= CURRENT_DATE " +
            "order by p.time")
    Page<Post> findPostsOrderByDateAsc(Pageable pageRequest);

    @Query("select p " +
            "from Post p " +
            "where p.isActive = true " +
            "and p.moderationStatus = 'ACCEPTED'" +
            "and p.time <= CURRENT_DATE " +
            "and p.title like :query OR p.text like :query " +
            "order by p.time DESC")
    Page<Post> findPostsByQuery(@Param("query") String query, Pageable pageRequest);

    @Query("select p " +
            "from Post p " +
            "inner join TagToPost ttp " +
                "on p.id = ttp.post_id.id "+
            "inner join Tag t " +
                "on ttp.tag_id.id = t.id " +
            "where p.isActive = true " +
            "and p.moderationStatus = 'ACCEPTED'" +
            "and p.time <= CURRENT_DATE " +
            "and t.name = :tag " +
            "order by p.time DESC")
    Page<Post> findPostsByTag(@Param("tag") String tag, Pageable pageRequest);

    @Query("select p.time as date, COUNT(p.id) as postCount " +
            "from Post p " +
            "where p.isActive = true " +
            "and p.moderationStatus = 'ACCEPTED'" +
            "and p.time <= CURRENT_DATE " +
            "GROUP BY date")
    List<CalendarProjection> calendarPost(@Param("year") int year); //DATE_FORMAT(p.time, '%Y-%m-%d')

    @Query(value = "select distinct DATE_FORMAT(p.time, '%Y') as year " +
            "from posts p " +
            "where p.is_active = true " +
            "and p.moderation_status = 'ACCEPTED'" +
            "and p.time <= CURRENT_DATE order by year", nativeQuery = true)
    Integer[] getPostsYears();  //DATEFORMAT(p.time, '%Y')  example of using native query

    @Query("select p " +
            "from Post p " +
            "inner join TagToPost ttp " +
            "on p.id = ttp.post_id.id "+
            "inner join Tag t " +
            "on ttp.tag_id.id = t.id " +
            "where p.isActive = true " +
            "and p.moderationStatus = 'ACCEPTED'" +
            "and p.time <= CURRENT_DATE " +
            "and t.name = :tag " +
            "order by p.time DESC")
    Page<Post> findPostsForModeration(@Param("tag") String tag, Pageable pageRequest);

    @Query("select p " +
            "from Post p " +
            "where p.isActive = true " +
            "and p.moderationStatus = 'ACCEPTED'" +
            "and p.time between :startDate and :endDate ")
    Page<Post> findPostsByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate, Pageable pageRequest);
}
