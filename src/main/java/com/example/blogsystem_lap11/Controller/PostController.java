package com.example.blogsystem_lap11.Controller;


import com.example.blogsystem_lap11.API.ApiResponse;
import com.example.blogsystem_lap11.Model.Category;
import com.example.blogsystem_lap11.Model.Post;
import com.example.blogsystem_lap11.Repository.PostRepository;
import com.example.blogsystem_lap11.Service.CategoryService;
import com.example.blogsystem_lap11.Service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {


    private final PostService postService;

    @GetMapping("/get")
    public ResponseEntity<List<Post>> getAll() {
        return ResponseEntity.status (200).body(postService.gelAllPost());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody Post post  , Errors errors) {

        if(errors.hasErrors())
        {
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));

        }        postService.addPost(post);
        return ResponseEntity.ok(new ApiResponse("Post added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody Post post , Errors errors) {


        if(errors.hasErrors())
        {
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));

        }
        postService.updatePost(id ,post);
            return ResponseEntity.ok(new ApiResponse("Post updated successfully"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {

        postService.deletePost(id);
            return ResponseEntity.ok(new ApiResponse("Post deleted successfully"));
    }


    @GetMapping("/getPostsByCategory/{categoryId}")
    public ResponseEntity<?> getPostsByCategory(@PathVariable Integer categoryId) {
        return ResponseEntity.ok(postService.getPostsByCategoryId(categoryId));
    }


    @GetMapping("/getPostsBefore/{date}")
    public ResponseEntity<?> getPostsBefore(@PathVariable String date) {
        LocalDate parsedDate = LocalDate.parse(date);
        return ResponseEntity.ok(postService.getPostsBeforeDate(parsedDate));
    }


    @GetMapping("/getPostsAfter/{date}")
    public ResponseEntity<?> getPostsAfter(@PathVariable String date) {
        LocalDate parsedDate = LocalDate.parse(date);
        return ResponseEntity.ok(postService.getPostsAfterDate(parsedDate));
    }


    @GetMapping("/getPostsByUser/{userId}")
    public ResponseEntity<?> getPostsByUser(@PathVariable Integer userId) {
        return ResponseEntity.ok(postService.getPostsByUserId(userId));
    }


    @GetMapping("/getPostByTitle/{title}")
    public ResponseEntity<?> getPostByTitle(@PathVariable String title) {
        Post post = postService.getPostByTitle(title);
        if (post == null) {
            return ResponseEntity.status(404).body( new ApiResponse("Post not found with title: " + title));
        }
        return ResponseEntity.ok(post);
    }






}
