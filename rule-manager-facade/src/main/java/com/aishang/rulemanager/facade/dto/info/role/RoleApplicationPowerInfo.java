package com.aishang.rulemanager.facade.dto.info.role;

import com.aishang.rulemanager.facade.dto.info.app.ApplicationInfo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * class_name：RoleApplicationPowerInfo
 * describe: 子系统角色权限
 * user: zhoujian
 * date：18-3-14
 */
public class RoleApplicationPowerInfo extends ApplicationInfo {

    private boolean power;                           // 权限

    private List<RoleResourcePowerInfo> listRes;     // 子系统模块

    public boolean isPower() {
        return power;
    }

    public void setPower(boolean power) {
        this.power = power;
    }

    public List<RoleResourcePowerInfo> getListRes() {
        return listRes;
    }

    public void setListRes(List<RoleResourcePowerInfo> listRes) {
        this.listRes = listRes;
    }

    @Override
    public String toString() {
        return "RoleApplicationPowerInfo{" +
                "power=" + power +
                ", listRes=" + listRes +
                "} " + super.toString();
    }
}
