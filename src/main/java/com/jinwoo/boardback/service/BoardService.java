package com.jinwoo.boardback.service;

import org.springframework.http.ResponseEntity;

import com.jinwoo.boardback.dto.request.board.PatchBoardRequestDto;
import com.jinwoo.boardback.dto.request.board.PostBoardRequestDto;
import com.jinwoo.boardback.dto.request.board.PostCommentRequestDto;
import com.jinwoo.boardback.dto.response.board.DeleteBoardResponseDto;
import com.jinwoo.boardback.dto.response.board.GetBoardResponseDto;
import com.jinwoo.boardback.dto.response.board.GetCommentListResponseDto;
import com.jinwoo.boardback.dto.response.board.GetFavoriteListResponseDto;
import com.jinwoo.boardback.dto.response.board.GetLatestBoardListResponseDto;
import com.jinwoo.boardback.dto.response.board.GetSearchBoardListResponseDto;
import com.jinwoo.boardback.dto.response.board.GetTop3BoardListResponseDto;
import com.jinwoo.boardback.dto.response.board.GetUserBoardListResponseDto;
import com.jinwoo.boardback.dto.response.board.IncreaseViewCountResponseDto;
import com.jinwoo.boardback.dto.response.board.PatchBoardResponseDto;
import com.jinwoo.boardback.dto.response.board.PostBoardResponseDto;
import com.jinwoo.boardback.dto.response.board.PostCommentResponseDto;
import com.jinwoo.boardback.dto.response.board.PutFavoriteResponseDto;


public interface BoardService {
    ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto, String email);
    ResponseEntity<? super PostCommentResponseDto> postComment(PostCommentRequestDto dto, Integer boardNumber, String email);
    
    ResponseEntity<? super GetBoardResponseDto> getboard(Integer boardNumber);
    ResponseEntity<? super GetFavoriteListResponseDto> getFavoriteList(Integer boardNumber);
    ResponseEntity<? super GetCommentListResponseDto> getCommentList(Integer boardNumber);

    ResponseEntity<? super GetLatestBoardListResponseDto> getLatestBoardList();
    ResponseEntity<? super GetUserBoardListResponseDto> getUserBoardList(String email);
    ResponseEntity<? super GetTop3BoardListResponseDto> getTop3BoardList();
    ResponseEntity<? super GetSearchBoardListResponseDto> getSearchBoardList(String searchword, String preSearchWord);

    ResponseEntity<? super PutFavoriteResponseDto> putFavorite(Integer boardNumber, String email);

    ResponseEntity<? super PatchBoardResponseDto> patchBoard(PatchBoardRequestDto dto, Integer boardNumer, String email);
    ResponseEntity<? super IncreaseViewCountResponseDto> increaseViewCount(Integer boardNumber);

    ResponseEntity<? super DeleteBoardResponseDto> deleteBoard(Integer boardNumber, String email);
}
