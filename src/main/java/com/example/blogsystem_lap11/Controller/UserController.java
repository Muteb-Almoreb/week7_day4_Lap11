package com.example.blogsystem_lap11.Controller;


import com.example.blogsystem_lap11.API.ApiResponse;
import com.example.blogsystem_lap11.Model.User;
import com.example.blogsystem_lap11.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    @GetMapping("/getAllUser")
    public ResponseEntity<?> getAllUser() {

        return ResponseEntity.status(200).body(userService.gelAllUser());

    }

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody @Valid User user, Errors errors) {

        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("The User Add successfully"));


    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        }

        userService.updateUser(id, user);
        return ResponseEntity.status(200).body(new ApiResponse("The User Update successfully"));

    }


    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {

        userService.deleteUser(id);
        return ResponseEntity.status(200).body(new ApiResponse("The User Delete successfully"));

    }


    @GetMapping("/getAllUserComment/{id}")
    public ResponseEntity<?> getAllUserComment(@PathVariable Integer id) {


        return ResponseEntity.status(200).body(userService.getAllUserComment(id));

    }


}