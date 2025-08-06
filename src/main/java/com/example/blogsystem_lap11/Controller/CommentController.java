package com.example.blogsystem_lap11.Controller;


import com.example.blogsystem_lap11.API.ApiResponse;
import com.example.blogsystem_lap11.Model.Comment;
import com.example.blogsystem_lap11.Model.User;
import com.example.blogsystem_lap11.Service.CommentService;
import com.example.blogsystem_lap11.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comment")
@RequiredArgsConstructor
public class CommentController {



    private final CommentService commentService;

    @GetMapping("/getAllComment")
    public ResponseEntity<?> getAllComment(){

        return ResponseEntity.status(200).body(commentService.getAllComment());

    }

    @PostMapping("/addComment")
    public ResponseEntity<?> addComment(@RequestBody @Valid Comment comment , Errors errors){

        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        }
        commentService.addComment(comment);
        return ResponseEntity.status(200).body(new ApiResponse("The Comment Add successfully"));


    }

    @PutMapping("/updateComment/{id}")
    public ResponseEntity<?> updateComment(@PathVariable Integer id , @RequestBody @Valid Comment comment , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        }

        commentService.updateComment(id , comment );
        return ResponseEntity.status(200).body(new ApiResponse("The Comment Update successfully"));

    }


    @DeleteMapping("/deleteComment/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Integer id){

        commentService.deleteComment(id);
        return ResponseEntity.status(200).body(new ApiResponse("The Comment Delete successfully"));

    }

    @GetMapping("/getCommentsByPost/{postId}")
    public ResponseEntity<?> getCommentsByPost(@PathVariable Integer postId) {
        return ResponseEntity.ok(commentService.getAllCommentsByPostId(postId));
    }


    @GetMapping("/getCommentsByCategory/{categoryId}")
    public ResponseEntity<?> getCommentsByCategory(@PathVariable Integer categoryId) {
        return ResponseEntity.ok(commentService.getCommentsByCategoryId(categoryId));
    }



}
