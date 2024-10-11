package com.argus.ecommerce.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import org.springframework.http.HttpStatus;

public class BaseResponse {
    private HttpStatus statusCode;
    private LocalDateTime time;
    private String message;
    private List<Object> content;
    private List<ServiceError> error;

    public BaseResponse() {
        content = new ArrayList<>();
        error = new ArrayList<>();
    }

    public Integer getStatusCode() {
        return this.statusCode.value();
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public String getTime() {
        return this.time.toString();
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Object> getContent() {
        return this.content;
    }

    public void setContent(List<Object> response) {
        this.content = response;
    }

    public List<ServiceError> getError() {
        return this.error;
    }

    public void setError(List<ServiceError> error) {
        this.error = error;
    }

}