package com.aishang.rulemanager.dal.model.vo;

import com.aishang.rulemanager.dal.model.User;

/**
 * Created by ylj on 18-3-6.
 */
public class UserVo extends User {
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
