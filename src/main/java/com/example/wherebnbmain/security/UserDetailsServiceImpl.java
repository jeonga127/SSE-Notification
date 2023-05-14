package com.example.wherebnbmain.security;

import com.example.wherebnbmain.entity.Users;
import com.example.wherebnbmain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String kakaoId) throws UsernameNotFoundException {
        Users user = userRepository.findByKakaoId(kakaoId)
                .orElseThrow(() -> new UsernameNotFoundException("로그인에 실패했습니다."));
        return new UserDetailsImpl(user, user.getKakaoId());
    }
}