package com.example.demo.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Integer id;

    private String descriptiion;

    @ManyToOne
    private Post post;


}
