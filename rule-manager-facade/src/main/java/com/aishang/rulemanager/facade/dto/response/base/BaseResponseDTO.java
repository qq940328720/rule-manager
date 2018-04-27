package com.aishang.rulemanager.facade.dto.response.base;

import java.io.Serializable;

/**
 * Created by neeke on 17-9-8.
 */
public class BaseResponseDTO implements Serializable {

    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseResponseDTO that = (BaseResponseDTO) o;

        return success == that.success;
    }

    @Override
    public int hashCode() {
        return (success ? 1 : 0);
    }

    @Override
    public String toString() {
        return "BaseResponseDTO{" +
                "success=" + success +
                '}';
    }
}
