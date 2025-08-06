package com.example.blogsystem_lap11.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {

    //Category
    //• category_id
    //• name


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int not null")
    private Integer category_id;




    @NotEmpty(message = "The Name must not be empty")
    @Column(columnDefinition = "varchar(50) not null")
    private String name;

}
