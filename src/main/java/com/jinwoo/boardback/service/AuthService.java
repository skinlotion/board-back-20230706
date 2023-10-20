package com.jinwoo.boardback.service;

import org.springframework.http.ResponseEntity;

import com.jinwoo.boardback.dto.request.auth.SignInRequestDto;
import com.jinwoo.boardback.dto.request.auth.SignUpRequestDto;
import com.jinwoo.boardback.dto.response.auth.SignInResponseDto;
import com.jinwoo.boardback.dto.response.auth.SignUpResponseDto;

public interface AuthService {
    ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);
    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
}
