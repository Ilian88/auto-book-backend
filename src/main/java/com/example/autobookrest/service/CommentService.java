package com.example.autobookrest.service;

import com.example.autobookrest.model.dto.CommentDTO;

import java.util.Set;

public interface CommentService {
    CommentDTO getById(Long id);

    Set<CommentDTO> getAllRootComments();
}
