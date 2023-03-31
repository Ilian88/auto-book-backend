package com.example.autobookrest.service.impl;

import com.example.autobookrest.model.dto.CommentDTO;
import com.example.autobookrest.model.view.UserView;
import com.example.autobookrest.repository.CommentRepository;
import com.example.autobookrest.service.CommentService;
import org.modelmapper.ModelMapper;
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
    public Set<CommentDTO> getRootComments() {
        return this.commentRepository.getAllByParentCommentIsNull()
                .stream()
                .map(c -> {
                    CommentDTO comment = modelMapper.map(c, CommentDTO.class);

                    comment.setOwner(
                            modelMapper.map(c.getOwner(), UserView.class)
                    );

                    return comment;
                }).collect(Collectors.toSet());
    }
}
