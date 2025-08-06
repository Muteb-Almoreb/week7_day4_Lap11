package com.example.blogsystem_lap11.Model;

import jakarta.persistence.*;
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
public class Post {

    //Post
    //• post_id
    //• category_id
    //• title
    //• content
    //• user_id
    //• publish_date

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int not null")
    private Integer post_id;

    @Column(columnDefinition = "int not null")
    @NotNull( message = "The category_id must not be Null")
    private Integer category_id;

    @NotEmpty(message = "Title must be not empty")
    @Column(columnDefinition = "varchar(50) not null")
    private String title;

    @NotEmpty(message = "Content must be not empty")
    @Column(columnDefinition = "varchar(100) not null")
    private String content;

    @NotNull(message = "user_id must be not empty")
    @Column(columnDefinition = "int not null")
    private Integer user_id;

    @Column(columnDefinition = "DATE NOT NULL DEFAULT CURRENT_DATE")
    private LocalDate publish_date;

    @PrePersist
    public void setPublishDateIfNull() {
        if (this.publish_date == null) {
            this.publish_date = LocalDate.now();
        }
    }
}
