package com.example.demo.Controller;

import com.example.demo.Model.Post;
import com.example.demo.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "posts/show";
    }

}
