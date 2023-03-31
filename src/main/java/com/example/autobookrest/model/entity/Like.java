package com.example.autobookrest.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "likes")
public class Like extends BaseEntity{
    private UserEntity owner;
    private Timestamp createdOn;

    public Like() {
    }

    @ManyToOne(targetEntity = UserEntity.class)
    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }
}
