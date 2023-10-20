package com.jinwoo.boardback.dto.response.board;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jinwoo.boardback.common.object.BoardListItem;
import com.jinwoo.boardback.dto.response.ResponseCode;
import com.jinwoo.boardback.dto.response.ResponseDto;
import com.jinwoo.boardback.dto.response.ResponseMessage;
import com.jinwoo.boardback.entity.BoardViewEntity;

import lombok.Getter;

@Getter
public class GetSearchBoardListResponseDto extends ResponseDto{
    private List<BoardListItem> searchList;
    
    private GetSearchBoardListResponseDto(String code, String message, List<BoardViewEntity> boardViewEntities) {
        super(code, message);
        this.searchList = BoardListItem.getList(boardViewEntities);
    }

    public static ResponseEntity<GetSearchBoardListResponseDto> success(List<BoardViewEntity> boardViewEntities) {
        GetSearchBoardListResponseDto result = new GetSearchBoardListResponseDto(ResponseCode.SUCCES, ResponseMessage.SUCCES, boardViewEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
