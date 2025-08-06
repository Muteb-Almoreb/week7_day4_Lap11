package com.example.blogsystem_lap11.Service;

import com.example.blogsystem_lap11.API.ApiException;
import com.example.blogsystem_lap11.Model.Post;
import com.example.blogsystem_lap11.Model.User;
import com.example.blogsystem_lap11.Repository.PostRepository;
import com.example.blogsystem_lap11.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> gelAllPost() {

        return postRepository.findAll();
    }



    public void addPost(Post post) {

        postRepository.save(post);

    }




    public void updatePost(Integer Id , Post post){

        Post oldePost = postRepository.getPostByPostId(Id);
        if(oldePost==null){
            throw new ApiException("The Post Not found");
        }

        oldePost.setTitle(post.getTitle());
        oldePost.setContent(post.getContent());



        postRepository.save(oldePost);

    }



    public void deletePost(Integer id){
        Post post = postRepository.getPostByPostId(id);
        if(post==null){
            throw new ApiException("The post Not found");
        }


        postRepository.delete(post);

    }

    public List<Post> getPostsByCategoryId(Integer categoryId) {
        return postRepository.getPostsByCategoryId(categoryId);
    }

    public List<Post> getPostsBeforeDate(LocalDate date) {
        return postRepository.getPostsBeforeDate(date);
    }

    public List<Post> getPostsAfterDate(LocalDate date) {
        return postRepository.getPostsAfterDate(date);
    }

    public List<Post> getPostsByUserId(Integer userId) {
        return postRepository.getPostsByUserId(userId);
    }

    public Post getPostByTitle(String title) {
        return postRepository.getPostByTitle(title);
    }







}
