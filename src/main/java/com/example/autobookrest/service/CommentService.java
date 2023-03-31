package com.example.autobookrest.service;

import com.example.autobookrest.model.dto.CommentDTO;
import com.example.autobookrest.model.entity.Comment;

import java.util.Set;

public interface CommentService {
    Set<CommentDTO> getRootComments();
}
