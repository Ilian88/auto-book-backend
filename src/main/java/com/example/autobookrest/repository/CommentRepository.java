package com.example.autobookrest.repository;

import com.example.autobookrest.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("SELECT c FROM Comment c JOIN CarEntity ce ON c.car.id = ce.id WHERE ce.id = :carId")
    Set<Comment> getCommentByCarId(@Param("carId") Long car_id);

    Set<Comment> findAllByParentCommentIsNull();
}
