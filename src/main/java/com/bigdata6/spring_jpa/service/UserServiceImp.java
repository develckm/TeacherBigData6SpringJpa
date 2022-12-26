package com.bigdata6.spring_jpa.service;

import com.bigdata6.spring_jpa.entity.User;
import com.bigdata6.spring_jpa.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements  UserService{
    private UserRepository userRepository;

    public UserServiceImp(UserRepository repository) {
        this.userRepository = repository;
    }


    @Override
    public List<User> listAllTest() {
        return userRepository.findAll();
    }

    @Override
    public User signup(User user) {
        return null;
    }

    @Override
    public User register(User user) {
        return null;
    }

    @Override
    public User userModify(User user) {
        return null;
    }

    @Override
    public User adminModify(User user) {
        return null;
    }

    @Override
    public User login(String id, String pw) {
        return null;
    }

    @Override
    public Page<User> list(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<User> detail(String id) {
        return userRepository.findById(id);
    }

    @Override
    public int idCheck(String id) {
        return 0;
    }

    @Override
    public int remove(String id) {
        return 0;
    }
}
