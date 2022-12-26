package com.bigdata6.spring_jpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

//JPA table 구조에 해당하는 Entity 를 기반으로 쿼리 자동 생성 -> 쿼리의 영속성을 관리
@Entity
@Table(name = "USER")
@Data
public class User {
    @Id //table.pk
    @Column(name = "user_id")
    private String userId;
    private String name;
    private String pw;
    private String phone;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
            insertable = false, updatable = false) //default 값이 있어서 등록 수정을 하지 않게 한다.
    private Date signup;
    @OneToMany
    @JoinColumn(name = "user_id",insertable = false,updatable = false)
    private List<Board> boardList;


}
