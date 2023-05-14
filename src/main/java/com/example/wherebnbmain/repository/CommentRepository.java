package com.example.wherebnbmain.repository;

import com.example.wherebnbmain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
