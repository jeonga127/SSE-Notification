package com.example.wherebnbmain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @JsonIgnore
    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users users;

    @JsonIgnore
    @JoinColumn(name = "memo_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Memo memo;

    public void setMemo(Memo memo) {
        this.memo = memo;
    }

    public Comment(String content, Users users, Memo memo) {
        this.content = content;
        this.users = users;
        this.memo = memo;
    }
}
