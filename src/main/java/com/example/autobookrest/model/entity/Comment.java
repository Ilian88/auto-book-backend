package com.example.autobookrest.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {

    private String text;
    private Comment parentComment;
    private Set<Comment> childrenComments;
    private UserEntity owner;
    private Timestamp createdOn;
    private Set<Like> likes;

    public Comment() {
        this.childrenComments = new HashSet<>();
        this.likes = new HashSet<>();
        this.parentComment = null;
    }
    public Comment(final Comment parentComment) {
        this.parentComment = parentComment;
        this.childrenComments = new HashSet<>();
        this.likes = new HashSet<>();
        registerInParentChildren();
    }

    @Column(columnDefinition = "TEXT")
    public String getText() {
        return text;
    }

    public Comment setText(String text) {
        this.text = text;
        return this;
    }

    @ManyToOne
    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    @OneToMany(mappedBy = "parentComment")
    public Set<Comment> getChildrenComments() {
        return childrenComments;
    }

    public void setChildrenComments(Set<Comment> childrenComments) {
        this.childrenComments = childrenComments;
    }

    @ManyToOne(targetEntity = UserEntity.class)
    public UserEntity getOwner() {
        return owner;
    }

    public Comment setOwner(UserEntity owner) {
        this.owner = owner;
        return this;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public Comment setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    @OneToMany(targetEntity = Like.class)
    public Set<Like> getLikes() {
        return likes;
    }

    public void setLikes(Set<Like> likes) {
        this.likes = likes;
    }

    private void registerInParentChildren() {
        this.parentComment.childrenComments.add(this);
    }
}
