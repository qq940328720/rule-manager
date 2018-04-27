package com.aishang.rulemanager.facade.dto.info.Log;

/**
 * lt
 */
public class OperationLogInfoDTO {

    private Integer id;

    private String method;

    private String uri;

    private String operator;

    private Long operatedAt;

    @Override
    public String toString() {
        return "OperationLogInfoDTO{" +
                "id=" + id +
                ", method='" + method + '\'' +
                ", uri='" + uri + '\'' +
                ", operator='" + operator + '\'' +
                ", operatedAt=" + operatedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OperationLogInfoDTO that = (OperationLogInfoDTO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (method != null ? !method.equals(that.method) : that.method != null) return false;
        if (uri != null ? !uri.equals(that.uri) : that.uri != null) return false;
        if (operator != null ? !operator.equals(that.operator) : that.operator != null) return false;
        return operatedAt != null ? operatedAt.equals(that.operatedAt) : that.operatedAt == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (method != null ? method.hashCode() : 0);
        result = 31 * result + (uri != null ? uri.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        result = 31 * result + (operatedAt != null ? operatedAt.hashCode() : 0);
        return result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Long getOperatedAt() {
        return operatedAt;
    }

    public void setOperatedAt(Long operatedAt) {
        this.operatedAt = operatedAt;
    }
}
