package com.tobeto.pair7Demo.core.utils.exceptions.problem;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ValidationProblemDetails extends ProblemDetails{
    private List<String> errors;

    public ValidationProblemDetails(List<String> errors) {
        setTitle("Validation Rule Violation");
        setDetail("One or more validation error(s)!");
        setType("ValidationException");
        this.errors = errors;
    }
}
