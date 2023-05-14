package com.example.wherebnbmain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MemoRequestDto {

    private Long id;
    private String title;
    private String content;
}