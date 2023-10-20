package com.jinwoo.boardback.dto.response.search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jinwoo.boardback.dto.response.ResponseCode;
import com.jinwoo.boardback.dto.response.ResponseDto;
import com.jinwoo.boardback.dto.response.ResponseMessage;
import com.jinwoo.boardback.repository.resultSet.SearchWordResultSet;

import lombok.Getter;

@Getter
public class GetRelationListResponseDto extends ResponseDto{
    
    private List<String> relativeWordList;
    
    private GetRelationListResponseDto(String code, String message, List<SearchWordResultSet> resultSets) {
        super(code, message);
        List<String> relativeWordList = new ArrayList<>();
        for(SearchWordResultSet resultSet : resultSets){
            String word = resultSet.getSearchWord();
            relativeWordList.add(word);
        }
        this.relativeWordList = relativeWordList;
    }

    public static ResponseEntity<GetRelationListResponseDto> success(List<SearchWordResultSet> resultSets) {
        GetRelationListResponseDto result = new GetRelationListResponseDto(ResponseCode.SUCCES, ResponseMessage.SUCCES, resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
