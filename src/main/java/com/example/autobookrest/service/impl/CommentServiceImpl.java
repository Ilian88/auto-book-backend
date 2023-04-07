package com.example.autobookrest.service.impl;

import com.example.autobookrest.model.dto.CommentDTO;
import com.example.autobookrest.model.entity.Comment;
import com.example.autobookrest.model.view.UserView;
import com.example.autobookrest.repository.CommentRepository;
import com.example.autobookrest.service.CommentService;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;


@Component
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    public CommentServiceImpl(CommentRepository commentRepository, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CommentDTO getById(Long id) {
        return this.modelMapper.map(
                this.commentRepository.findById(id).orElseThrow(),
                CommentDTO.class
                );
    }

    @Override
    public Set<CommentDTO> getAllRootComments() {
        return
                this.commentRepository.findAllByParentCommentIsNull()
                .stream()
                .map(c -> modelMapper.map(c, CommentDTO.class))
                .collect(Collectors.toSet());

    }
}
