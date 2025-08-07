package com.example.blogsystem_lap11.Service;


import com.example.blogsystem_lap11.API.ApiException;
import com.example.blogsystem_lap11.Model.Comment;
import com.example.blogsystem_lap11.Model.Post;
import com.example.blogsystem_lap11.Model.User;
import com.example.blogsystem_lap11.Repository.CategoryRepository;
import com.example.blogsystem_lap11.Repository.CommentRepository;
import com.example.blogsystem_lap11.Repository.PostRepository;
import com.example.blogsystem_lap11.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {


    private final CommentRepository commentRepository;

    private final PostRepository postRepository;

    public List<Comment> getAllComment(){
       return commentRepository.findAll();

    }

    public void addComment(Comment comment) {
      Post post=  postRepository.getPostByPostId(comment.getPost_id());
        if(post==null) {
            throw new ApiException("The Post Not found");
        }

        commentRepository.save(comment);
        }







    public void updateComment(Integer Id , Comment comment){

        Comment oldeComment = commentRepository.getCommentByCommentId(Id);
        if(oldeComment==null){
            throw new ApiException("The Comment Not found");
        }

        oldeComment.setContent(comment.getContent());



        commentRepository.save(oldeComment);

    }



    public void deleteComment(Integer id){
        Comment comment = commentRepository.getCommentByCommentId(id);
        if(comment==null){
            throw new ApiException("The Comment Not found");
        }

        commentRepository.delete(comment);

    }


    public List<Comment> getAllCommentsByPostId(Integer postId) {
        return commentRepository.getCommentsByPostId(postId);
    }

    public List<Comment> getCommentsByCategoryId(Integer categoryId) {
        return commentRepository.getCommentsByCategoryId(categoryId);
    }








}
