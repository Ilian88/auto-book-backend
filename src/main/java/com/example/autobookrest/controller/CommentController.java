package com.example.autobookrest.controller;

import com.example.autobookrest.model.dto.CommentDTO;
import com.example.autobookrest.model.entity.Comment;
import com.example.autobookrest.repository.CommentRepository;
import com.example.autobookrest.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping()
    public ResponseEntity<Set<CommentDTO>> getAllComments() {
        Set<CommentDTO> comments = this.commentService.getRootComments();

        return ResponseEntity.ok(comments);
    }
}
