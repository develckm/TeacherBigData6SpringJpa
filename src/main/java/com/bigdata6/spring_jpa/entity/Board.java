package com.bigdata6.spring_jpa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ToString(exclude = {"user"})
//양방향 참조의 무한 재귀를 막기 위해 user 출력을 제외
// toString 이 참조의 트리거가 되기 때문에
// 유저가 보드를 참조하고 다시 보드가 유저를 참조하고 다시 유저가 보드를 참조....하는 무한 반복을 막아함.
@Entity
@Table(name = "BOARD")
public class Board {
    @Id
    @Column(name = "board_no")
    private int boardNo;//board_no
    private String title;//title
    private String contents;//contents

    @Column(name = "post_time",
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
            updatable = false,insertable = false)
    private Date postTime;//post_time
    //user.userId 와 중복되기 때문에 사용할 수 없다.
    //@Column(name = "user_id")
    //private String userId;//user_id  //fetch.lazy 에서 User 를 호출하지 않기 위해

    //@ManyToOne(fetch = FetchType.EAGER) //board 를 조회할때 마다 무조건 조인
    //타임리프를 렌더링 하는중 userId 외의 필드를 호출하면(트리거) 조인하는 것 처럼 select 한다.
    private int views;//views
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",updatable = false) //update user_id=? 하지 않게 설정
    private User user; //Board : User = N : 1 (fk user_id)


    //private List<ReplyDto> replyList;
    //private List<BoardImgDto> boardImgList;
}
