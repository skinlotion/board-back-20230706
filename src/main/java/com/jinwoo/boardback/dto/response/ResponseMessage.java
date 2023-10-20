package com.jinwoo.boardback.dto.response;

public interface ResponseMessage {
    
    String SUCCES = "Success.";
    
    String VALIDATION_FAILD = "Validation failed.";
    String DUPLICATED_EMAIL = "Duplicated email.";
    String DUPLICATED_NICKNAME = "Duplicate nickname.";
    String DUPLICATED_TEL_NUMBER = "Duplicate telephone number.";
    String NOT_EXIST_USER = "This user does not exist.";
    String NOT_EXIST_BOARD = "This board does not exist.";
    String NO_PERMISSION = "Do not have permission.";

    String SIGN_IN_FAILED = "Login information mismatch.";

    String DATABASE_ERROR = "Database error.";
}
