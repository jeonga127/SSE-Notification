package com.example.wherebnbmain.dto;

import com.example.wherebnbmain.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CommentDto {
    private String username;
    private String content;

    public CommentDto(Comment comment) {
        this.username = comment.getUsers().getUsername();
        this.content = comment.getContent();
    }
}