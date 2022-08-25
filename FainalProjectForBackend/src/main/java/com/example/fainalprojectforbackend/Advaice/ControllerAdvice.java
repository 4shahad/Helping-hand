package com.example.fainalprojectforbackend.Advaice;

import com.example.fainalprojectforbackend.Exception.ApiException;
import com.example.fainalprojectforbackend.dto.ApiResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import javax.validation.UnexpectedTypeException;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value= ApiException.class)
    public ResponseEntity apiException(ApiException apiException){
        return ResponseEntity.status(400).body( new ApiResponse(apiException.getMessage(),400));
    }

    @ExceptionHandler(value =DataIntegrityViolationException.class )
   public ResponseEntity dataIntegrityViolationException(DataIntegrityViolationException dataIntegrityViolationException){
        String message=dataIntegrityViolationException.getMessage();
      return   ResponseEntity.status(500).body(new ApiResponse(message,500));
    }

    @ExceptionHandler(value =TransactionSystemException.class )
    public ResponseEntity transactionSystemException(TransactionSystemException transactionSystemException){
        String message=transactionSystemException.getMessage();
        return   ResponseEntity.status(500).body(new ApiResponse(message,500));
    }
    @ExceptionHandler(value = UnexpectedTypeException.class)
    public ResponseEntity unexpectedTypeException(UnexpectedTypeException unexpectedTypeException){
        String message=unexpectedTypeException.getMessage();
        return   ResponseEntity.status(500).body(new ApiResponse(message,500));
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity constraintViolationException(ConstraintViolationException constraintViolationException){
        String message=constraintViolationException.getMessage();
        return   ResponseEntity.status(500).body(new ApiResponse(message,500));
    }
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity httpMessageNotReadableException(HttpMessageNotReadableException httpMessageNotReadableException){
        String message=httpMessageNotReadableException.getMessage();
        return   ResponseEntity.status(400).body(new ApiResponse(message,400));
    }
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseEntity missingServletRequestParameterException(MissingServletRequestParameterException missingServletRequestParameterException){
        String message=missingServletRequestParameterException.getMessage();
        return   ResponseEntity.status(400).body(new ApiResponse(message,400));

    }
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException){
        String message=httpRequestMethodNotSupportedException.getMessage();
        return   ResponseEntity.status(400).body(new ApiResponse(message,400));

    }
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity nullPointerException(NullPointerException nullPointerException){
        String message=nullPointerException.getMessage();
        return   ResponseEntity.status(500).body(new ApiResponse(message,500));

    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(Exception exception){
        exception.printStackTrace();
        return   ResponseEntity.status(500).body(new ApiResponse("server hase problem",500));

    }
}
