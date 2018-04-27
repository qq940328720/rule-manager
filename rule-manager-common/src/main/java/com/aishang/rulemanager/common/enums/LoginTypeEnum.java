package com.aishang.rulemanager.common.enums;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

@JsonSerialize(using = LoginTypeEnum.LoginTypeEnumJsonSerializer.class)
public enum LoginTypeEnum {
    SYSTEM(1, "后台登录"),
    API(2, "API认证"),
    OUT(3, "登出");

    private Integer code;
    private String message;
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    LoginTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    LoginTypeEnum() {
    }

    public static LoginTypeEnum getLogenum(Integer integer) {
        for (LoginTypeEnum logenum : LoginTypeEnum.values()) {
            if (logenum.getCode() == integer) {
                return logenum;
            }
        }
        return null;
    }

    public static class LoginTypeEnumJsonSerializer extends JsonSerializer<LoginTypeEnum> {
        @Override
        public void serialize(LoginTypeEnum logenum, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (null != logenum) {
                jsonGenerator.writeStartObject();
                jsonGenerator.writeFieldName("code");
                jsonGenerator.writeObject(logenum.code);
                jsonGenerator.writeFieldName("message");
                jsonGenerator.writeObject(logenum.message);
                jsonGenerator.writeEndObject();
            } else {
                jsonGenerator.writeNull();
            }
        }
    }
}
