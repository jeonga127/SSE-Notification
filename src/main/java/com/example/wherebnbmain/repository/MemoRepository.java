package com.example.wherebnbmain.repository;

import com.example.wherebnbmain.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo, Long> {
}
