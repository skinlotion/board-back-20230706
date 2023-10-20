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
public class GetTop3BoardListResponseDto extends ResponseDto{
    private List<BoardListItem> top3List;

    private GetTop3BoardListResponseDto (String code, String message, List<BoardViewEntity> boardViewEntity) {
        super(code, message);
        this.top3List = BoardListItem.getList(boardViewEntity);
    }

    public static ResponseEntity<GetTop3BoardListResponseDto> success(List<BoardViewEntity> boardViewEntities) {
        GetTop3BoardListResponseDto result = new GetTop3BoardListResponseDto(ResponseCode.SUCCES, ResponseMessage.SUCCES, boardViewEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    
}
