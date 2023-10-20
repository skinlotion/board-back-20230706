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
public class GetPopularListResponseDto extends ResponseDto{
    
    private List<String> popularWordList;

    private GetPopularListResponseDto(String code, String message, List<SearchWordResultSet> resultSets){
        super(code, message);
        List<String> popularWordList = new ArrayList<>();
        for (SearchWordResultSet resultSet : resultSets) {
            String word = resultSet.getSearchWord();
            popularWordList.add(word);
        }
        this.popularWordList = popularWordList;
    }

    public static ResponseEntity<GetPopularListResponseDto> success(List<SearchWordResultSet> resultSets) {
        GetPopularListResponseDto result = new GetPopularListResponseDto(ResponseCode.SUCCES, ResponseMessage.SUCCES, resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
