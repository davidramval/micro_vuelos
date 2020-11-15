package com.semillero.aerolinea.utilities.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> exception(Exception ex, WebRequest request) {
        logger.error(ex.getMessage(), ex);
        return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex));
    }

    @ExceptionHandler({ApiNotFound.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> apiNotFound(ApiNotFound ex, WebRequest request) {
        logger.error(ex.getMessage(), ex);
        return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND, ex.getMessage(), ex));
    }

    @ExceptionHandler({ApiPasajeroConflict.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Object> apiPasajeroConflict(ApiPasajeroConflict ex, WebRequest request) {
        logger.error(ex.getMessage(), ex);
        return buildResponseEntity(new ApiError(HttpStatus.CONFLICT, ex.getMessage(), ex));
    }

    @ExceptionHandler({ApiUnauthorizazed.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<Object> apiUnauthorizazed(ApiUnauthorizazed ex, WebRequest request) {
        logger.error(ex.getMessage(), ex);
        return buildResponseEntity(new ApiError(HttpStatus.UNAUTHORIZED, ex.getMessage(), ex));
    }

    @ExceptionHandler({ApiUnprossesableEntity.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<Object> apiUnprossesableEntity(ApiUnprossesableEntity ex, WebRequest request) {
        logger.error(ex.getMessage(), ex);
        return buildResponseEntity(new ApiError(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage(), ex));
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
