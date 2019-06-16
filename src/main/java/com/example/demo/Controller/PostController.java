package com.example.demo.Controller;

import com.example.demo.Model.Comment;
import com.example.demo.Model.Post;
import com.example.demo.Repository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {

    private PostRepository postRepository;

    public PostController(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @RequestMapping("/add")
    public String addPost(ModelMap modelMap){
        modelMap.put("post" , new Post());
        return "posts/add"; // skierowanie do pliku html
    }

    @PostMapping("")
    public String createPost(@ModelAttribute Post post , ModelMap modelMap){
        postRepository.save(post);
        modelMap.put("post" , post);
        return "redirect:/posts/"+post.getId();
    }

    @GetMapping("/{id}")
    public String showPost(@PathVariable Integer id, ModelMap modelMap){
        Post post = postRepository.findById(id).get();
        modelMap.put("post", post);
        Comment comment = new Comment();
        comment.setPost(post);
        modelMap.put("comment", comment);
        return "posts/show";
    }

}
