package com.example.blogsystem_lap11.Repository;

import com.example.blogsystem_lap11.Model.Comment;
import com.example.blogsystem_lap11.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentRepository extends JpaRepository<Comment , Integer> {

    @Query("select c from Comment c where c.comment_id = ?1")
    Comment getCommentByCommentId(Integer comment_id);

    @Query("select c from Comment c where c.user_id = ?1")
    List<Comment> getCommentsByUserId(Integer userId);

    @Query("select c from Comment c where c.post_id = ?1")
    List<Comment> getCommentsByPostId(Integer postId);

    @Query("select c from Comment c where c.post_id in (select p.post_id from Post p where p.category_id = ?1)")
    List<Comment> getCommentsByCategoryId(Integer categoryId);


}
