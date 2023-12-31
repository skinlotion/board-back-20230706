package com.jinwoo.boardback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jinwoo.boardback.entity.SearchLogEntity;
import com.jinwoo.boardback.repository.resultSet.SearchWordResultSet;

@Repository
public interface SearchlogRepository extends JpaRepository<SearchLogEntity, Integer> {
    @Query(
        value = 
        "SELECT search_word AS searchWord, COUNT(*) AS count " +
        "FROM search_log " +
        "WHERE relation IS FALSE " +
        "GROUP BY search_word " +
        "ORDER BY count DESC " +
        "LIMIT 15 ",
        nativeQuery = true  
    )
    List<SearchWordResultSet> getPopularWordList();

    @Query(
        value =  
        "SELECT relation_word AS searchWord, COUNT(*) AS count " +
        "FROM search_log " +
        "WHERE search_word = ?1 " +
        "AND relation_word IS NOT NULL " +
        "GROUP BY relation_word " +
        "ORDER BY count DESC " +
        "LIMIT 15 ",
        nativeQuery = true
    )
    List<SearchWordResultSet> getRelationWordList(String searchWord);
}
