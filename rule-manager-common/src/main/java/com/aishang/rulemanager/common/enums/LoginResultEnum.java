package com.aishang.rulemanager.common.enums;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

@JsonSerialize(using = LoginResultEnum.LoinResultenumJsonSerializer.class)
public enum LoginResultEnum {
    SUCCESS(1, "成功"),
    EXECUTED(0, "失败");

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

    LoginResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    LoginResultEnum() {
    }

    public static LoginResultEnum getLoginResultEnum(Integer integer) {
        for (LoginResultEnum logenum : LoginResultEnum.values()) {
            if (logenum.getCode() == integer) {
                return logenum;
            }
        }
        return null;
    }

    public static class LoinResultenumJsonSerializer extends JsonSerializer<LoginResultEnum> {


        @Override
        public void serialize(LoginResultEnum loginResultenum, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            if (null != loginResultenum) {
                jsonGenerator.writeStartObject();
                jsonGenerator.writeFieldName("code");
                jsonGenerator.writeObject(loginResultenum.code);
                jsonGenerator.writeFieldName("message");
                jsonGenerator.writeObject(loginResultenum.message);
                jsonGenerator.writeEndObject();
            } else {
                jsonGenerator.writeNull();
            }
        }
    }
}
