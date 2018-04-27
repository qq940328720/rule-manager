package com.aishang.rulemanager.web.controller.base;


import com.aishang.rulemanager.common.MyObjectMapper;
import com.aishang.rulemanager.common.enums.ErrorCode;
import com.aishang.rulemanager.facade.dto.response.base.ResponseDTOWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.*;

/**
 * Created by neeke on 17-9-4.
 * 全局异常统一处理类
 */
@RestControllerAdvice
public class GlobalExceptionController extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionController.class);

    @ExceptionHandler({Exception.class})
    protected ResponseDTOWrapper allException(Exception ex, Locale locale) {
        return createResponseDTOWrapper(ex, ErrorCode.EXCEPTION);
    }

    @ExceptionHandler({IllegalArgumentException.class})
    protected ResponseDTOWrapper illegalArgumentException(IllegalArgumentException ex, Locale locale) {
        return createResponseDTOWrapper(ex, ErrorCode.ILLEGAL_ARGUMENT_EXCEPTION);
    }

    @ExceptionHandler({BadCredentialsException.class})
    protected ResponseDTOWrapper badCredentialsException(BadCredentialsException ex) {
        return createResponseDTOWrapper(ex, ErrorCode.BAD_CREDENTIALS_EXCEPTION);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    protected ResponseDTOWrapper constraintViolationException(ConstraintViolationException ex) {
        LOGGER.error("异常", ex);
        Set<ConstraintViolation<?>> result = ex.getConstraintViolations();
        Map<String, String> errors = new HashMap<>(result.size());
        for (ConstraintViolation violation : result) {
            errors.put(violation.getPropertyPath().toString(), violation.getMessage());
        }
        ResponseDTOWrapper responseDTOWrapper = new ResponseDTOWrapper();
        responseDTOWrapper.setMessage(ErrorCode.METHOD_ARGUMENT_NOT_VALID_EXCEPTION.getMessage());
        responseDTOWrapper.setCode(ErrorCode.METHOD_ARGUMENT_NOT_VALID_EXCEPTION.getCode());
        responseDTOWrapper.setArgErrors(errors);
        return responseDTOWrapper;
    }

    private ResponseDTOWrapper createResponseDTOWrapper(Exception ex, ErrorCode errorCode) {
        LOGGER.error("异常", ex);
        ResponseDTOWrapper responseDTOWrapper = new ResponseDTOWrapper();
        responseDTOWrapper.setMessage(errorCode.getMessage());
        responseDTOWrapper.setCode(errorCode.getCode());
        return responseDTOWrapper;
    }

    //    @Override
//    @ExceptionHandler(RestExpiredJwtException.class)
//    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        return new ResponseEntity<>(new ResponseDTOWrapper(false, "异常", ex, ErrorCode.EXPIRED_JWT_EXCEPTION), status);
//    }
//
    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return createResponseEntity(ex, ErrorCode.NO_HANDLER_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return createResponseEntity(ex, ErrorCode.HANDLE_HTTP_MEDIA_TYPE_NOT_ACCEPTABLE);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return createResponseEntity(ex, ErrorCode.HTTP_REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return createResponseEntity(ex, ErrorCode.EXCEPTION);
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return createResponseEntity(ex, ErrorCode.EXCEPTION);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return createResponseEntity(ex, ErrorCode.EXCEPTION);
    }

    @Override
    protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return createResponseEntity(ex, ErrorCode.EXCEPTION);
    }

    @Override
    protected ResponseEntity<Object> handleConversionNotSupported(ConversionNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return createResponseEntity(ex, ErrorCode.EXCEPTION);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return createResponseEntity(ex, ErrorCode.EXCEPTION);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return createResponseEntity(ex, ErrorCode.EXCEPTION);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return createResponseEntity(ex, ErrorCode.EXCEPTION);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<ObjectError> fieldErrors = ex.getBindingResult().getAllErrors();
        Map<String, String> errors = new HashMap<>(fieldErrors.size());
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return createResponseEntity(ex, ErrorCode.METHOD_ARGUMENT_NOT_VALID_EXCEPTION, errors);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestPart(MissingServletRequestPartException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return createResponseEntity(ex, ErrorCode.EXCEPTION);
    }

    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ObjectError> fieldErrors = ex.getBindingResult().getAllErrors();
        Map<String, String> errors = new HashMap<>(fieldErrors.size());
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return createResponseEntity(ex, ErrorCode.EXCEPTION, errors);
    }

    @Override
    protected ResponseEntity<Object> handleAsyncRequestTimeoutException(AsyncRequestTimeoutException ex, HttpHeaders headers, HttpStatus status, WebRequest webRequest) {
        return createResponseEntity(ex, ErrorCode.EXCEPTION);
    }

    private ResponseEntity<Object> createResponseEntity(Exception ex, ErrorCode errorCode) {
        LOGGER.error("异常", ex);
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            return new ResponseEntity<>(MyObjectMapper.getInstance().writeValueAsString(new ResponseDTOWrapper(errorCode.getCode(), errorCode.getMessage())), headers, HttpStatus.OK);
        } catch (Exception e) {
            return null;
        }
    }

    private ResponseEntity<Object> createResponseEntity(Exception ex, ErrorCode errorCode, Map<String, String> errors) {
        LOGGER.error("异常", ex);
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
            return new ResponseEntity<>(MyObjectMapper.getInstance().writeValueAsString(new ResponseDTOWrapper(errorCode.getCode(), errorCode.getMessage(), errors)), headers, HttpStatus.OK);
        } catch (Exception e) {
            return null;
        }
    }
}
