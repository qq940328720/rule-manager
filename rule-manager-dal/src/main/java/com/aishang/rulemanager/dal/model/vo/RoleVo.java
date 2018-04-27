package com.aishang.rulemanager.dal.model.vo;

import com.aishang.rulemanager.dal.model.Role;

/**
 * Created by ylj on 18-3-3.
 */
public class RoleVo extends Role {

    private Integer isChecked;

    public Integer getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Integer isChecked) {
        this.isChecked = isChecked;
    }

    @Override
    public String toString() {
        return "RoleVo{" +
                "isChecked=" + isChecked +
                "} " + super.toString();
    }
}
