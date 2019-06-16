package com.example.demo.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Integer id;

    private String content;

    @OneToMany(mappedBy = "post") // mappedBy mowi do ktorego pola Klasy post sie odnosimy
    private List<Comment> comments = new ArrayList<>();

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }

}
