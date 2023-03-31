package com.example.autobookrest.bean;

import com.example.autobookrest.model.dto.CommentDTO;
import com.example.autobookrest.model.entity.Comment;
import com.example.autobookrest.model.view.UserView;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class ApplicationBeanConfig {
    @Bean
    ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addConverter(new AbstractConverter<Comment, CommentDTO>() {
            @Override
            protected CommentDTO convert(Comment comment) {
                if (comment == null) {
                    return null;
                }

                CommentDTO dto = new CommentDTO();
                dto.setCreatedOn(comment.getCreatedOn());
                dto.setText(comment.getText());
                if (comment.getLikes() != null) {
                    dto.setLikes(comment.getLikes());
                }

                dto.setOwner(modelMapper.map(comment.getOwner(), UserView.class));
                setChildren(comment, dto);

                return dto;
            }
        });

        return modelMapper;
    }

    private void setChildren(Comment comment, CommentDTO commentDTO) {
        Deque<CommentDTO> commentDTOQ = new ArrayDeque<>();
        Deque<Comment> commentQ = new ArrayDeque<>();

        commentDTOQ.offer(commentDTO);
        commentQ.offer(comment);

        while (!commentQ.isEmpty() && !commentDTOQ.isEmpty()) {
            Comment currentComment = commentQ.poll();
            CommentDTO currentDTO = commentDTOQ.poll();

            Set<CommentDTO> dtos = new HashSet<>();

            for (Comment childrenComment : currentComment.getChildrenComments()) {
                dtos.add(modelMapper().map(childrenComment, CommentDTO.class));

                commentQ.offer(childrenComment);
            }

            dtos.forEach(commentDTOQ::offer);
            currentDTO.setChildrenComments(dtos);
        }
    }
}
