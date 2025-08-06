package com.example.blogsystem_lap11.Repository;

import com.example.blogsystem_lap11.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {


    @Query("select u from User u where u.user_id = ?1")
    User getUserByUserId(Integer user_id);


}
