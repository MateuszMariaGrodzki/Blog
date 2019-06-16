package com.example.demo.Repository;

import com.example.demo.Model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment , Integer> {

}
