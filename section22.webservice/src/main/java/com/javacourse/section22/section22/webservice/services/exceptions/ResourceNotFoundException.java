package com.javacourse.section22.section22.webservice.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id){
        super("Resource not found. Id " + id);
    }

}
