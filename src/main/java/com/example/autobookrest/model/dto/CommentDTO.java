package com.example.autobookrest.model.dto;

import com.example.autobookrest.model.entity.Comment;
import com.example.autobookrest.model.entity.Like;
import com.example.autobookrest.model.entity.UserEntity;
import com.example.autobookrest.model.view.UserView;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommentDTO {
    private String text;
//    private Comment parentComment;
    private Set<CommentDTO> childrenComments;
    private UserView owner;
    private Timestamp createdOn;
    private Set<Like> likes;

    public CommentDTO() {
        this.childrenComments = new HashSet<>();
        this.likes = new HashSet<>();
    }

    public String getText() {
        return text;
    }

    public CommentDTO setText(String text) {
        this.text = text;
        return this;
    }

    public UserView getOwner() {
        return owner;
    }

    public CommentDTO setOwner(UserView owner) {
        this.owner = owner;
        return this;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public CommentDTO setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public Set<Like> getLikes() {
        return likes;
    }

    public CommentDTO setLikes(Set<Like> likes) {
        this.likes = likes;
        return this;
    }

//    public Comment getParentComment() {
//        return parentComment;
//    }
//
//    public void setParentComment(Comment parentComment) {
//        this.parentComment = parentComment;
//    }

    public Set<CommentDTO> getChildrenComments() {
        return childrenComments;
    }

    public void setChildrenComments(Set<CommentDTO> childrenComments) {
        this.childrenComments = childrenComments;
    }
}
