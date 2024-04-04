package com.tobeto.pair7Demo.core.utils.exceptions.problem;

public class BusinessProblemDetails extends ProblemDetails{

    public BusinessProblemDetails(String detail) {
        setDetail(detail);
        setTitle("Business Rule Violation");
        setType("BusinessException");
    }
}
