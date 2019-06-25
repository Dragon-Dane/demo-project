package com.bio.demo.Execptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

public class ServiceExceptionHolder {
    @Getter
    @RequiredArgsConstructor
    public static class ServiceException extends RuntimeException {
        private final String entity;
        private final String entityName;
        private final int code;
        private final String message;
    }

    public static class ResourceNotFoundException extends ServiceException {
        public ResourceNotFoundException(String entityName, String message) {
            super(null, entityName, 2000, message);
        }
    }

    public static class EntityNotFoundException extends ResourceNotFoundException {
        public EntityNotFoundException(String entityName, UUID uuid) {
            super(entityName , "No " + entityName + " found with ID: " + uuid);
        }
    }

    public static class EntityHasChildren extends ServiceException {
        public EntityHasChildren(String entityName, String message) {
            super(null, entityName, 4003 ,message );
        }
    }

    public static class ConstraintViolation extends  ServiceException{
        public ConstraintViolation(String entityName, String message) {
            super(null, entityName, 4003 ,message );
        }
    }
}
