package com.jinwoo.boardback.dto.response.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jinwoo.boardback.dto.response.ResponseCode;
import com.jinwoo.boardback.dto.response.ResponseDto;
import com.jinwoo.boardback.dto.response.ResponseMessage;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignUpResponseDto extends ResponseDto{

        private SignUpResponseDto(String code, String message) {
                super(code, message);
        }

        public static ResponseEntity<SignUpResponseDto> succes() {
                SignUpResponseDto result = new SignUpResponseDto(ResponseCode.SUCCES, ResponseMessage.SUCCES);
                return ResponseEntity.status(HttpStatus.OK).body(result);
        }

        public static ResponseEntity<ResponseDto> duplicateEamil() {
                ResponseDto result = new ResponseDto(ResponseCode.DUPLICATED_EMAIL, ResponseMessage.DUPLICATED_EMAIL);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }

        public static ResponseEntity<ResponseDto> duplicateNickname() {
                ResponseDto result = new ResponseDto(ResponseCode.DUPLICATED_NICKNAME, ResponseMessage.DUPLICATED_NICKNAME);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }

        public static ResponseEntity<ResponseDto> duplicateTelNumber() {
                ResponseDto result = new ResponseDto(ResponseCode.DUPLICATED_TEL_NUMBER, ResponseMessage.DUPLICATED_TEL_NUMBER);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }

}
