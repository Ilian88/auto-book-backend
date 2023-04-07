package com.example.autobookrest.controller;

import com.example.autobookrest.model.dto.CommentDTO;
import com.example.autobookrest.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Set<CommentDTO>> getAllRootComments() {
        Set<CommentDTO> comments = this.commentService.getAllRootComments();

        return ResponseEntity.ok().body(comments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDTO> getCommentById(@PathVariable Long id) {
        CommentDTO comments = this.commentService.getById(id);

        return ResponseEntity.ok(comments);
    }
}
