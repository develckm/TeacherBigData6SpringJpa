package com.bigdata6.spring_jpa.repository;

import com.bigdata6.spring_jpa.entity.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    Logger log=LoggerFactory.getLogger(this.getClass());
    @Test
    void save() {
        User user=new User();
        user.setUserId("gildong1234");
        user.setName("길동이일이삼사");
        user.setPw("01234");
        user.setPhone("010-12345-1112");
        user.setEmail("gildong12340@gmail.com");
        user.setBirth(new Date());
        User saveUser = userRepository.save(user);
    }

    @Transactional
    @Test
    void findById() {
        Optional<User> userOpt=userRepository.findById("user1");
        userOpt.ifPresent((user)->{
            log.info(user.toString());
        });
    }

    @Test
    void count() {
    }

    @Test
    void deleteById() {
        userRepository.deleteById("gildong1234");
    }

    @Test
    void findAll() {
        //List<User> userList =userRepository.findAll();
        Pageable pageable =PageRequest.of(0,4, Sort.by("userId").descending());
        Page<User> userList =userRepository.findAll(pageable); //Page : List+navi 정보
        log.info(userList.getContent().toString());
        log.info(userList.getSize()+"");
        log.info(userList.isFirst()+"");
        log.info(userList.getTotalPages()+"");
    }
}