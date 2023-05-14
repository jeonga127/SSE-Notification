package com.example.wherebnbmain.dto;

import com.example.wherebnbmain.entity.Memo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MemoResponseDto {
    private Long id;
    private String title;
    private String content;
    private List<CommentDto> comments = new ArrayList<>();

    public MemoResponseDto(Memo memo) {
        this.id = memo.getId();
        this.title = memo.getTitle();
        this.content = memo.getContent();
        this.comments = memo.getComments().stream().map(CommentDto::new).collect(Collectors.toList());
    }
}
