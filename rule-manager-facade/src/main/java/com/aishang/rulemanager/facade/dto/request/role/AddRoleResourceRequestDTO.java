package com.aishang.rulemanager.facade.dto.request.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * class_name：AddRoleResourceRequestDTO
 * describe: 新增角色资源请求对象
 * user: zhoujian
 * date：18-3-2
 */
@ApiModel(value = "新增角色资源请求对象")
public class AddRoleResourceRequestDTO {

    @ApiModelProperty(value = "权限编号")
    private List<String> resCodes;

    public List<String> getResCodes() {
        return resCodes;
    }

    public void setResCodes(List<String> resCodes) {
        this.resCodes = resCodes;
    }

    @Override
    public String toString() {
        return "AddRoleResourceRequestDTO{" +
                "resCodes=" + resCodes +
                '}';
    }
}
