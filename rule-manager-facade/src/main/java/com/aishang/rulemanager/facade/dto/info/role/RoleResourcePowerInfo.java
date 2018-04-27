package com.aishang.rulemanager.facade.dto.info.role;

import com.aishang.rulemanager.facade.dto.info.resource.ResourceInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by IntelliJ IDEA.
 * class_name：RoleResourcePowerInfo
 * describe: TODO
 * user: zhoujian
 * date：18-3-14
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleResourcePowerInfo extends ResourceInfo {

    // 角色对该资源是否有权限
    private boolean power;

    public boolean isPower() {
        return power;
    }

    public void setPower(boolean power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "RoleResourcePowerInfo{" +
                "power=" + power +
                "} " + super.toString();
    }
}
