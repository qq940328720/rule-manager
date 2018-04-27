package com.aishang.rulemanager.facade.dto.request.user;

import com.aishang.rulemanager.facade.dto.info.user.RoleInfoDTO;

import java.util.List;

/**
 * Created by ylj on 18-3-2.
 */
public class UserAssignRoleRequestDTO extends UserBaseRequestDTO {

    private List<RoleInfoDTO> data;

    public List<RoleInfoDTO> getData() {
        return data;
    }

    public void setData(List<RoleInfoDTO> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "UserAssignRoleRequestDTO{" +
                "data=" + data +
                "} " + super.toString();
    }
}
