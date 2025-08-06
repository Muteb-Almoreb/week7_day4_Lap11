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
public class Comment {

    //Comment
    //• comment_id
    //• user_id
    //• post_id
    //• content
    //• comment_date

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int not null")
    private Integer comment_id;


    @Column(columnDefinition = "int not null")
    @NotNull( message = "The user_id must not be Null")
    private Integer user_id;

    @Column(columnDefinition = "int not null")
    @NotNull( message = "The post_id must not be Null")
    private Integer post_id;

    @Column(columnDefinition = "varchar(200) not null")
    @NotEmpty( message = "The content must not be Null")
    private String content;

    @Column(columnDefinition = "DATE NOT NULL DEFAULT CURRENT_DATE")
    private LocalDate comment_date;

    @PrePersist
    public void setPublishDateIfNull() {
        if (this.comment_date == null) {
            this.comment_date = LocalDate.now();
        }
    }

}
