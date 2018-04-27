package com.aishang.rulemanager.facade.dto.request.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * Created by IntelliJ IDEA.
 * class_name：AddRoleRequestDTO
 * describe: 新增角色请求对象
 * user: zhoujian
 * date：18-3-2
 */
@ApiModel(value = "新增角色请求对象")
public class AddRoleRequestDTO {

    @ApiModelProperty(value = "角色名称")
    @NotBlank(message = "角色名称不能为空")
    private String roleName;

    @ApiModelProperty(value = "角色描述")
    private String description;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "AddRoleRequestDTO{" +
                "roleName='" + roleName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
