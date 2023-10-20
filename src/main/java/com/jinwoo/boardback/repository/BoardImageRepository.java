package com.jinwoo.boardback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jinwoo.boardback.entity.BoardImageEntity;
import java.util.List;

import javax.transaction.Transactional;


@Repository
public interface BoardImageRepository extends JpaRepository<BoardImageEntity, Integer> {

    List<BoardImageEntity> findByBoardNumber(Integer boardNumber);
    
    @Transactional
    void deleteByBoardNumber(Integer boardNumber);

    
}
