package com.bio.demo.DataClass;

import lombok.Data;

import java.util.List;

@Data
public class ResponseObject {
    private  int code;
    private String action;
    private  String message;
    private  List<String> errors;
    private  String entityName;
    private  Object entity;

    public ResponseObject(int code, String message, List<String> errors , Object entity, String entityName, String action) {
        this.code = code;
        this.message = message;
        this.errors = errors;
        this.entity = entity;
        this.entityName = entityName;
        this.action = action;
    }
}
