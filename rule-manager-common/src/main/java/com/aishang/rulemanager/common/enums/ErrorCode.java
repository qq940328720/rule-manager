package com.aishang.rulemanager.common.enums;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

/**
 * Created by neeke on 17-9-7.
 */
@JsonSerialize(using = ErrorCode.ErrorCodeJsonSerializer.class)
public enum ErrorCode {

    OK("100", "操作成功"),
    ACCESS_DENIED("101", "访问被拒绝"),
    NO_HANDLER_FOUND("102", "该页面不存在"),
    AUTHENTICATION_EXCEPTION("103", "身份认证异常"),
    AUTHENTICATION_FAILURE("104", "身份认证失败"),
    EXCEPTION("105", "异常"),
    ILLEGAL_ARGUMENT_EXCEPTION("106", "非法参数"),
    BAD_CREDENTIALS_EXCEPTION("107", "账号或密码错误"),
    METHOD_ARGUMENT_NOT_VALID_EXCEPTION("108", "参数校验不通过"),
    HANDLE_HTTP_MEDIA_TYPE_NOT_ACCEPTABLE("109", "不接受的媒体类型"),
    HTTP_REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION("110", "不支持的请求方法"),
    FAIL("111", "操作失败");

    private String code;
    private String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static class ErrorCodeJsonSerializer extends JsonSerializer<ErrorCode> {

        @Override
        public void serialize(ErrorCode errorCode, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (null != errorCode) {
                jsonGenerator.writeStartObject();
                jsonGenerator.writeFieldName("code");
                jsonGenerator.writeObject(errorCode.code);
                jsonGenerator.writeFieldName("message");
                jsonGenerator.writeObject(errorCode.message);
                jsonGenerator.writeEndObject();
            } else {
                jsonGenerator.writeNull();
            }
        }
    }
}
