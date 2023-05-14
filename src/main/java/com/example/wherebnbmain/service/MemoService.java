package com.example.wherebnbmain.service;

import com.example.wherebnbmain.dto.CommentDto;
import com.example.wherebnbmain.dto.MemoRequestDto;
import com.example.wherebnbmain.dto.MemoResponseDto;
import com.example.wherebnbmain.dto.ResponseDto;
import com.example.wherebnbmain.entity.Comment;
import com.example.wherebnbmain.entity.Memo;
import com.example.wherebnbmain.entity.Users;
import com.example.wherebnbmain.repository.MemoRepository;
import com.example.wherebnbmain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MemoService {

    private final MemoRepository memoRepository;
    private final UserRepository userRepository;
    private final NotificationService notificationService;


    @Transactional
    public ResponseDto saveMemo(Users user, MemoRequestDto memoRequestDto) {
        memoRepository.save(new Memo(memoRequestDto.getTitle(), memoRequestDto.getContent(), user));
        return ResponseDto.setSuccess("Success : save memo", null);
    }

    @Transactional(readOnly = true)
    public List<MemoResponseDto> findAllMemo() {
        List<MemoResponseDto> memoList = memoRepository.findAll().stream().map(MemoResponseDto::new).collect(Collectors.toList());
        return memoList;
    }

    @Transactional(readOnly = true)
    public MemoResponseDto findMemo(Long id) {
        Memo memo = memoRepository.findById(id).orElseThrow(() -> new NoSuchElementException("존재 ㄴㄴ"));
        return new MemoResponseDto(memo);
    }

    @Transactional
    public ResponseDto addComment(Long id, CommentDto commentDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(() -> new NoSuchElementException("존재 ㄴㄴ"));
        Users user = userRepository.findByUsername(commentDto.getUsername()).orElseThrow(() -> new NoSuchElementException("존재 ㄴㄴ"));
        Comment comment = new Comment(commentDto.getContent(), user, memo);
        memo.addComment(comment);
        notificationService.notifyAddCommentEvent(memo);
        return ResponseDto.setSuccess("Success : add Comment", new MemoResponseDto(memo));
    }
}
