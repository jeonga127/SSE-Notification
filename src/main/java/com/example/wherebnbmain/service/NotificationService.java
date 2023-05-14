package com.example.wherebnbmain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import com.example.wherebnbmain.entity.Memo;
import com.example.wherebnbmain.repository.MemoRepository;

import static com.example.wherebnbmain.controller.SseController.sseEmitters;

@Transactional
@RequiredArgsConstructor
@Service
public class NotificationService {

    private final MemoRepository memoRepository;

    public void notifyAddCommentEvent(Memo memo) {

        Long userId = memo.getUser().getId();

        if (sseEmitters.containsKey(userId)) {
            SseEmitter sseEmitter = sseEmitters.get(userId);
            try {
                sseEmitter.send(SseEmitter.event().name("addComment").data("댓글이 달렸습니다!!!!!"));
            } catch (Exception e) {
                sseEmitters.remove(userId);
            }
        }
    }
}