package com.jinwoo.boardback.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jinwoo.boardback.dto.response.ResponseDto;
import com.jinwoo.boardback.dto.response.search.GetPopularListResponseDto;
import com.jinwoo.boardback.dto.response.search.GetRelationListResponseDto;
import com.jinwoo.boardback.repository.SearchlogRepository;
import com.jinwoo.boardback.repository.resultSet.SearchWordResultSet;
import com.jinwoo.boardback.service.SearchService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SearchServiceImplement implements SearchService{
    
    private final SearchlogRepository searchlogRepository;
    
    @Override
    public ResponseEntity<? super GetPopularListResponseDto> getPopularList() {
        
        List<SearchWordResultSet> resultSets = new ArrayList<>();
        
        try {
            
            resultSets = searchlogRepository.getPopularWordList();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetPopularListResponseDto.success(resultSets);
    }

    @Override
    public ResponseEntity<? super GetRelationListResponseDto> getRelationList(String searchWord) {
        
        List<SearchWordResultSet> resultSets = new ArrayList<>();

        try {

            resultSets = searchlogRepository.getRelationWordList(searchWord);
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetRelationListResponseDto.success(resultSets);
    }
    
}
