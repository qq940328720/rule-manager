package com.aishang.rulemanager.facade.dto.response.role;

import com.aishang.rulemanager.facade.dto.response.base.BaseResponseDTO;

public class RoleBaseResponseDTO extends BaseResponseDTO {

    private String message;         // 返回消息提示

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "RoleBaseResponseDTO{" +
                "message='" + message + '\'' +
                '}';
    }
}
