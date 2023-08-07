package br.com.mutualizo.desafio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<JsonError> handleMissingRequestParam(MissingServletRequestParameterException ex) {
        String errorMessage = "O parâmetro '" + ex.getParameterName() + "' não foi informado.";
        JsonError errorResponse = new JsonError(
            HttpStatus.BAD_REQUEST.value(),
            LocalDateTime.now().toString(),
            errorMessage
        );
        return ResponseEntity.badRequest().body(errorResponse);
    }

}
