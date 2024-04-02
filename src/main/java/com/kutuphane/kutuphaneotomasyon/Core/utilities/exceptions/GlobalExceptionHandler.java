package com.kutuphane.kutuphaneotomasyon.Core.utilities.exceptions;

import com.kutuphane.kutuphaneotomasyon.Core.utilities.exceptions.problemDetails.BusinessProblemDetails;
import com.kutuphane.kutuphaneotomasyon.Core.utilities.exceptions.problemDetails.ValidationProblemDetails;
import com.kutuphane.kutuphaneotomasyon.Core.utilities.exceptions.types.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BusinessProblemDetails handleRuntimeException(BusinessException exception)
    {
        BusinessProblemDetails businessProblemDetails = new BusinessProblemDetails();
        businessProblemDetails.setDetail(exception.getMessage());
        return businessProblemDetails;
    }


    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationProblemDetails handleValidationException(MethodArgumentNotValidException exception)
    {
        Map<String,String> validationErrors = new HashMap<>();

        exception.getBindingResult().getFieldErrors().stream().map(error ->
                validationErrors.put(error.getField(),error.getDefaultMessage())
        ).toList();

        ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
        validationProblemDetails.setErrors(validationErrors);
        return validationProblemDetails;
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(Exception exception)
    {
        return "Bilinmedik hata";
    }
}
