package com.aishang.rulemanager.facade.dto.request.role;

import com.aishang.rulemanager.facade.dto.request.base.BaseRequestParameters;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * class_name：AddRoleRequestDTO
 * describe: 新增角色请求对象
 * user: zhoujian
 * date：18-3-2
 */
@ApiModel(value = "查询角色请求对象")
public class QueryRoleRequestDTO extends BaseRequestParameters {

    @ApiModelProperty(value = "角色编号")
    private String roleCode;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "创建人")
    private String createName;

    @ApiModelProperty(value = "创建开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createStartTime;

    @ApiModelProperty(value = "创建结束时间")
    //@Pattern(regexp = Commonkeys.DATE_REGEXP, message = "创建结束时间格式错误，应为“yyyy-MM-dd”格式")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createEndTime;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getCreateStartTime() {
        return createStartTime;
    }

    public void setCreateStartTime(Date createStartTime) {
        this.createStartTime = createStartTime;
    }

    public Date getCreateEndTime() {
        return createEndTime;
    }

    public void setCreateEndTime(Date createEndTime) {
        this.createEndTime = createEndTime;
    }

    @Override
    public String toString() {
        return "QueryRoleRequestDTO{" +
                "roleCode='" + roleCode + '\'' +
                ", roleName='" + roleName + '\'' +
                ", createName='" + createName + '\'' +
                ", createStartTime='" + createStartTime + '\'' +
                ", createEndTime='" + createEndTime + '\'' +
                '}';
    }
}
