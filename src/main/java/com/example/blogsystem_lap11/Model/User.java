package com.example.blogsystem_lap11.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {


    //user_id
    //• username
    //• password
    //• email
    //• registration_date
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int")
    private Integer user_id;


    @NotEmpty(message = "The userName must not be empty")
    @Column(columnDefinition = "varchar(50) not null unique")
    private String username;


    @Email(message = "Email must be correct")
    @NotEmpty(message = "Password must be not empty")
    @Column(columnDefinition = "varchar(200) not null unique")
    private String email;

    @NotEmpty(message = "Password must be not empty")
    @Column(columnDefinition = "varchar(50) not null")
    private String password;


    @Column(columnDefinition = "DATE NOT NULL DEFAULT CURRENT_DATE")
    private LocalDate registration_date;

    @PrePersist
    public void setRegistrationDateIfNull() {
        if (this.registration_date == null) {
            this.registration_date = LocalDate.now();
        }

    }


}
