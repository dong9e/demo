package com.example.bookingsticker.exception;

import com.example.bookingsticker.entity.ErrorCode;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@Data
public class CustomException extends RuntimeException {
    public static final CustomException INVALID_ARGUMENT = new CustomException(ErrorCode.INVALID_ARGUMENT.name());
    public static final CustomException NOT_FOUND = new CustomException(ErrorCode.NOT_FOUND.name());

    public String code;
    public String message;
    public List<String> errors;

    public CustomException(String code){
        this.code = code;
    }

    public CustomException(ErrorCode code){
        this.code = code.name();
    }

    public CustomException(String code, String message, List<String> errors){
        this.code = code;
        this.message = message;
        this.errors = errors;
    }

    public CustomException withMessage(String message){
        return new CustomException(this.code, message, this.errors);
    }

    public CustomException addError(String error){
        if (StringUtils.isNotEmpty(error))
            this.errors.add(error);
        return new CustomException(this.code, this.message, this.errors);
    }



}
