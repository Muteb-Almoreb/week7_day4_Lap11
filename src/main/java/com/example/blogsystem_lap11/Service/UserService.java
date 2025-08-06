package com.example.blogsystem_lap11.Service;

import com.example.blogsystem_lap11.API.ApiException;
import com.example.blogsystem_lap11.Model.Comment;
import com.example.blogsystem_lap11.Model.User;
import com.example.blogsystem_lap11.Repository.CommentRepository;
import com.example.blogsystem_lap11.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    public List<User> gelAllUser() {

        return userRepository.findAll();
    }

    public void addUser(User user) {

        userRepository.save(user);

    }




    public void updateUser(Integer Id , User user){

        User oldeUser = userRepository.getUserByUserId(Id);
        if(oldeUser==null){
            throw new ApiException("The User Not found");
        }

        oldeUser.setUsername(user.getUsername());
        oldeUser.setEmail(user.getEmail());
        oldeUser.setPassword(user.getPassword());
      //  oldeUser.setRegistration_date(user.getRegistration_date());

        userRepository.save(oldeUser);

    }



    public void deleteUser(Integer id){
        User user = userRepository.getUserByUserId(id);
        if(user==null){
            throw new ApiException("The User Not found");
        }

        userRepository.delete(user);

    }


    public List<Comment> getAllUserComment(Integer idUser)
    {
        return commentRepository.getCommentsByUserId(idUser);

    }







}
