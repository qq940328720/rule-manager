package com.aishang.rulemanager.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 单例，全局ObjectMapper
 */
public class MyObjectMapper {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static ObjectMapper getInstance() {
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // ObjectMapper转换忽略多余字段
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return OBJECT_MAPPER;
    }


}
