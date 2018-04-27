package com.aishang.rulemanager.facade.dto.request.resource;

import com.aishang.rulemanager.facade.dto.request.base.BaseRequestDTO;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ResourceBaseRequestDTO extends BaseRequestDTO {

    @ApiModelProperty(value = "应用编号")
    @NotNull
    @NotEmpty
    private String appCode;

    @ApiModelProperty(value = "资源编号")
    @NotNull
    @NotEmpty
    private String code;

    @ApiModelProperty(value = "父资源编号")
    @NotNull
    @NotEmpty
    private String parentCode;

    @ApiModelProperty(value = "资源类型（1.面板；2.按钮；3.菜单）")
    @NotNull
    @NotEmpty
    private String type;

    @ApiModelProperty(value = "排序")
    @NotNull
    @NotEmpty
    private Integer order;

    @NotNull
    @NotEmpty
    private String visible;

    @NotNull
    @NotEmpty
    private String enabled;

    @ApiModelProperty(value = "资源地址")
    @NotNull
    @NotEmpty
    private String uri;

    @ApiModelProperty(value = "资源图标")
    private String icon;

    @ApiModelProperty(value = "资源描述")
    private String description;

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
