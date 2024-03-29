package com.example.autobookrest.model.entity;

import com.example.autobookrest.model.enums.Gender;
import com.example.autobookrest.model.enums.Role;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity{

    private String username;
    private String email;
    private String password;
    private Gender gender;
    private Role role;
    private List<CarEntity> cars;

    private Set<Comment> comments;

    private Set<Like> likes;

    public UserEntity() {
    }

    @Column(name = "username", unique = true, nullable = false)
    @Size(min = 4)
    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    @Enumerated(EnumType.STRING)
    public Gender getGender() {
        return gender;
    }

    public UserEntity setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    @Enumerated(EnumType.STRING)
    public Role getRole() {
        return role;
    }

    public UserEntity setRole(Role role) {
        this.role = role;
        return this;
    }

    @OneToMany(mappedBy = "owner", targetEntity = CarEntity.class)
    public List<CarEntity> getCars() {
        return cars;
    }

    public UserEntity setCars(List<CarEntity> cars) {
        this.cars = cars;
        return this;
    }

    @OneToMany(mappedBy = "owner")
    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @OneToMany(mappedBy = "owner")
    public Set<Like> getLikes() {
        return likes;
    }

    public void setLikes(Set<Like> likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", role=" + role +
                ", cars=" + cars +
                ", comments=" + comments +
                ", likes=" + likes +
                '}';
    }
}
