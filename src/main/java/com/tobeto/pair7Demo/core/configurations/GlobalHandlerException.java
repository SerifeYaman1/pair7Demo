package com.tobeto.pair7Demo.core.configurations;

import com.tobeto.pair7Demo.core.utils.exceptions.problem.BusinessProblemDetails;
import com.tobeto.pair7Demo.core.utils.exceptions.problem.ValidationProblemDetails;
import com.tobeto.pair7Demo.core.utils.exceptions.types.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BusinessProblemDetails handleBussinesException(BusinessException exception){

        BusinessProblemDetails businessProblemDetails = new BusinessProblemDetails(exception.getMessage());
        return businessProblemDetails;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationProblemDetails handleValidationException(MethodArgumentNotValidException exception){

        List<String> errorMessages = new ArrayList<>();

        List<FieldError> errors = exception.getBindingResult().getFieldErrors();

        for (FieldError error:errors){
            errorMessages.add(error.getDefaultMessage());
        }
        ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails(errorMessages);

        return  validationProblemDetails;
    }


}
