package com.bigdata6.spring_jpa.repository;

import com.bigdata6.spring_jpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    @Override
    <S extends User> S save(S entity);

    @Override
    Optional<User> findById(String s);

    @Override
    long count();

    @Override
    void deleteById(String s);

    @Override
    Page<User> findAll(Pageable pageable);

}
