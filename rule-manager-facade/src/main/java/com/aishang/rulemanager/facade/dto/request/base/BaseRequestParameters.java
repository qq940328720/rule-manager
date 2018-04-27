package com.aishang.rulemanager.facade.dto.request.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by neeke on 17-9-9.
 */
@ApiModel(value = "请求参数", description = "非JSON传参时使用")
public class BaseRequestParameters implements Serializable {

    @ApiModelProperty(value = "当前页显示条数")
    private Integer limit = 20;
    @ApiModelProperty(value = "起始页")
    private Integer offset = 0;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseRequestParameters that = (BaseRequestParameters) o;
        return Objects.equals(limit, that.limit) &&
                Objects.equals(offset, that.offset);
    }

    @Override
    public int hashCode() {
        return Objects.hash(limit, offset);
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return "RequestParameters{" +
                "limit=" + limit +
                ", offset=" + offset +
                '}';
    }
}
