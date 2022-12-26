package com.bigdata6.spring_jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BoardRepositoryTest {
    @Autowired
    BoardRepository boardRepository;

    @Transactional
    @Test
    void updateViews() {
        boardRepository.updateViews(2);
    }
    @Test
    void findAll(){
        System.out.println(boardRepository.findAll());
    }
    //fechType.lazy :view를 렌더링 하는 것을 기다리는데 test는 view를 렌더하지 않아서 오류가 발생
    @Transactional
    @Test
    void findById(){
        //boardRepository.findById(2);
        System.out.println(boardRepository.findById(2));
    }
}