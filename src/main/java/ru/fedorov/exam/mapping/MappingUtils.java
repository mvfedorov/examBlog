package ru.fedorov.exam.mapping;

import ru.fedorov.exam.api.response.PostByIdResponse;
import ru.fedorov.exam.api.response.PostResponse;
import ru.fedorov.exam.api.response.responseclasses.PostCommentDTO;
import ru.fedorov.exam.api.response.responseclasses.UserDTO;
import ru.fedorov.exam.api.response.responseclasses.UserWithPhoto;
import ru.fedorov.exam.model.Post;
import ru.fedorov.exam.model.PostComment;
import ru.fedorov.exam.model.User;

import java.util.concurrent.TimeUnit;

public class MappingUtils {
    //from User to UserDTO
    public static UserDTO userToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        return userDTO;
    }

    //from User to UserDTO
    public static UserWithPhoto userToUserWithPhoto(User user) {
        UserWithPhoto userWithPhoto = new UserWithPhoto();
        userWithPhoto.setId(user.getId());
        userWithPhoto.setName(user.getName());
        userWithPhoto.setPhoto(user.getPhoto());
        return userWithPhoto;
    }

    //from Post to PostDTO
    //TODO Time to UTC format, announce without HTML tags
    public static PostResponse.Post postToPostDTO(Post post) {
        PostResponse.Post postDTO = new PostResponse.Post();
        postDTO.setId(post.getId());
        postDTO.setTimestamp(TimeUnit.MILLISECONDS.toSeconds(post.getTime().getTime()));
        postDTO.setTitle(post.getTitle());
        postDTO.setAnnounce(post.getText());
        postDTO.setLikeCount(post.getLikeCount());
        postDTO.setDislikeCount(post.getDislikeCount());
        postDTO.setCommentCount(post.getCommentCount());
        postDTO.setViewCount(post.getViewCount());
        postDTO.setUser(userToUserDTO(post.getUser()));
        return postDTO;
    }

    public static PostByIdResponse postToPostByIdResponse(Post post) {

        PostByIdResponse postById = new PostByIdResponse();

        postById.setId(post.getId());
        postById.setTimestamp(TimeUnit.MILLISECONDS.toSeconds(post.getTime().getTime()));
        postById.setActive(post.isActive());
        postById.setUser(userToUserDTO(post.getUser()));
        postById.setTitle(post.getTitle());
        postById.setText(post.getText());

        postById.setLikeCount(post.getLikeCount());
        postById.setDislikeCount(post.getDislikeCount());
        postById.setViewCount(post.getViewCount());
        postById.setComments(post.getPostComments().stream().map(MappingUtils::postCommentToPostCommentDTO).toArray(PostCommentDTO[]::new));

        return postById;
    }

    //from Comment To CommentDTO
    public static PostCommentDTO postCommentToPostCommentDTO(PostComment comment) {

        PostCommentDTO CommentDTO = new PostCommentDTO();

        CommentDTO.setId(comment.getId());
        CommentDTO.setText(comment.getText());
        CommentDTO.setUser(userToUserWithPhoto(comment.getUser()));

        return CommentDTO;
    }

    /*public static PostByIdResponse postToPostByIdResponse(Post post) {
        PostByIdResponse postById = new PostByIdResponse();

        postById.setId(post.getId());
        postById.setTimestamp(post.getTime().getTime());
        postById.setActive(post.isActive());
        postById.setUser(userTo post.getUser());
        postById.setId(post.getId());
        postById.setId(post.getId());
        postById.setId(post.getId());
        postById.setId(post.getId());
        postById.setId(post.getId());
        postById.setId(post.getId());
        postById.setId(post.getId());
        postById.setId(post.getId());
        postById.setId(post.getId());


        //TODO last change
        *//*postDTO.setId(post.getId());
        postDTO.setTimestamp(post.getTime().getTime());
        postDTO.setTitle(post.getTitle());
        postDTO.setAnnounce(post.getText());
        postDTO.setLikeCount(0);
        postDTO.setDislikeCount(0);
        postDTO.setCommentCount(0);
        postDTO.setViewCount(0);
        postDTO.setUser(UserToUserDTO(post.getUser()));*//*

        return postById;
    }*/

}
