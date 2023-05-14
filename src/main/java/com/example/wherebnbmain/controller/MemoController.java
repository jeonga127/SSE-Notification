package com.example.wherebnbmain.controller;

import com.example.wherebnbmain.dto.CommentDto;
import com.example.wherebnbmain.dto.MemoRequestDto;
import com.example.wherebnbmain.dto.MemoResponseDto;
import com.example.wherebnbmain.dto.ResponseDto;
import com.example.wherebnbmain.security.UserDetailsImpl;
import com.example.wherebnbmain.service.MemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    @PostMapping("/memo")
    public ResponseDto postMemo(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody MemoRequestDto memoRequestDto) {
       return memoService.saveMemo(userDetails.getUser(), memoRequestDto);
    }

    @GetMapping("/memos")
    public List<MemoResponseDto> getAllMemos() {
        return memoService.findAllMemo();
    }

    @GetMapping("/memo")
    public MemoResponseDto getMemo(@RequestParam Long id) {
        return memoService.findMemo(id);
    }

    @PostMapping("/memo/{id}/comment")
    public ResponseDto addComment(@PathVariable Long id, @RequestBody CommentDto commentDto) {
        return memoService.addComment(id, commentDto);
    }
}