package com.aishang.rulemanager.facade.dto.response.base;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Map;
import java.util.Objects;

/**
 * Created by neeke on 17-9-7.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "响应", description = "接口调用响应")
public class ResponseDTOWrapper{

    @ApiModelProperty(value = "数据")
    private Object data;
    @ApiModelProperty(value = "错误码")
    private String code;
    @ApiModelProperty(value = "提示信息")
    private String message;
    @ApiModelProperty(value = "错误参数")
    private Map<String, String> argErrors;
    private Long totalCount;

    public ResponseDTOWrapper(Object data) {
        this.data = data;
    }

    public ResponseDTOWrapper(String code, String message) {
        this.code = code;
        this.message = message;
    }


    public ResponseDTOWrapper(Object data, String code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public ResponseDTOWrapper() {

    }

    public ResponseDTOWrapper(String code, String message, Map<String, String> argErrors) {
        this.code = code;
        this.message = message;
        this.argErrors = argErrors;
    }

    public ResponseDTOWrapper(Object data, String code, String message, Map<String, String> argErrors) {

        this.data = data;
        this.code = code;
        this.message = message;
        this.argErrors = argErrors;
    }

    public ResponseDTOWrapper(Object data, String code, String message, Map<String, String> argErrors, Long totalCount) {
        this.data = data;
        this.code = code;
        this.message = message;
        this.argErrors = argErrors;
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "ResponseDTOWrapper{" +
                "data=" + data +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", argErrors=" + argErrors +
                ", totalCount=" + totalCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseDTOWrapper that = (ResponseDTOWrapper) o;
        return Objects.equals(data, that.data) &&
                Objects.equals(code, that.code) &&
                Objects.equals(message, that.message) &&
                Objects.equals(argErrors, that.argErrors) &&
                Objects.equals(totalCount, that.totalCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, code, message, argErrors, totalCount);
    }

    public Long getTotalCount() {

        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Object getData() {

        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getArgErrors() {
        return argErrors;
    }

    public void setArgErrors(Map<String, String> argErrors) {
        this.argErrors = argErrors;
    }
}
