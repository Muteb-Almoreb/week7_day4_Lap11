package com.example.blogsystem_lap11.Repository;

import com.example.blogsystem_lap11.Model.Post;
import com.example.blogsystem_lap11.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {


    @Query("select p from Post p where p.post_id = ?1")
    Post getPostByPostId(Integer post_id);

    @Query("select p from Post p where p.category_id = ?1")
    List<Post> getPostsByCategoryId(Integer categoryId);


    @Query("select p from Post p where p.publish_date < ?1")
    List<Post> getPostsBeforeDate(LocalDate date);

    @Query("select p from Post p where p.publish_date > ?1")
    List<Post> getPostsAfterDate(LocalDate date);


    @Query("select p from Post p where p.user_id = ?1")
    List<Post> getPostsByUserId(Integer userId);

    @Query("select p from Post p where p.title = ?1")
    Post getPostByTitle(String title);







}
