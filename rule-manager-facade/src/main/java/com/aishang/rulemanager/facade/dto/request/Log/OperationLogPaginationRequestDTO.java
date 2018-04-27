package com.aishang.rulemanager.facade.dto.request.Log;

import com.aishang.rulemanager.facade.dto.request.base.BaseRequestParameters;
import io.swagger.annotations.ApiModelProperty;

/**
 * lt
 */
public class OperationLogPaginationRequestDTO extends BaseRequestParameters {
    @ApiModelProperty(value = "操作方法名称")
    private String name;
    @ApiModelProperty(value = "操作人")
    private String operator;
    @ApiModelProperty(value = "起始时间")
    private Long start;
    @ApiModelProperty(value = "结束时间")
    private Long end;

    @Override
    public String toString() {
        return "OperationLogPaginationRequestDTO{" +
                "name='" + name + '\'' +
                ", operator='" + operator + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        OperationLogPaginationRequestDTO that = (OperationLogPaginationRequestDTO) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (operator != null ? !operator.equals(that.operator) : that.operator != null) return false;
        if (start != null ? !start.equals(that.start) : that.start != null) return false;
        return end != null ? end.equals(that.end) : that.end == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        result = 31 * result + (start != null ? start.hashCode() : 0);
        result = 31 * result + (end != null ? end.hashCode() : 0);
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }
}
