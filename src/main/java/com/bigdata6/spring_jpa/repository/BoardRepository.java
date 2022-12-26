package com.bigdata6.spring_jpa.repository;

import com.bigdata6.spring_jpa.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends CrudRepository<Board,Integer> {
    @Modifying
    @Query("UPDATE Board b SET b.views=b.views+1 WHERE b.boardNo=:boardNo")
    void updateViews(@Param("boardNo") Integer boardNo);
    //UPDATE board set views=1+views WHERE board_no=boardNo
}
