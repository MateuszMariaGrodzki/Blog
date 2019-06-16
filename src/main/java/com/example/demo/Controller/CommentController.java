package com.example.demo.Controller;

import com.example.demo.Model.Comment;
import com.example.demo.Repository.CommentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/comments")
public class CommentController {

    private CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @PostMapping("")
    public String create(@ModelAttribute Comment comment){
        commentRepository.save(comment);
        return "redirect:/posts/"+comment.getPost().getId();
    }
}
