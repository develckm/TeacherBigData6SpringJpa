package com.bigdata6.spring_jpa.service;


import com.bigdata6.spring_jpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

//save 오류를 제외하고 무조건 실행 (있으면 등록, 없으면 수정)
public interface UserService {
    List<User> listAllTest();
    User signup(User user);
    User register(User user);

    User userModify(User user);
    User adminModify(User user);

    User login(String id, String pw);
    Page<User> list(Pageable pageable);
    Optional<User> detail(String id);
    int idCheck(String id);//0:존재하지 않는 아이디,1:존재하는 아이디,-1:오류
    int remove(String id);
}
