package com.bigdata6.spring_jpa.dto;

import com.bigdata6.spring_jpa.entity.Board;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import java.util.List;

@Data
public class UserDto {
    private String userId; //user_id
    private String name;
    private String pw;
    private String phone;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date signup;

}
