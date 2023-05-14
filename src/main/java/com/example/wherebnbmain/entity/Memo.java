package com.example.wherebnbmain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users user;

    @OneToMany(mappedBy = "memo", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    public Memo(String title, String content, Users users) {
        this.title = title;
        this.content = content;
        this.user = users;
    }

    public void addComment(Comment comment) {
        this.getComments().add(comment);
        comment.setMemo(this);
    }
}
