package com.aishang.rulemanager.facade.dto.request.app;

import com.aishang.rulemanager.facade.dto.request.base.BaseRequestDTO;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Created by mx on 18-3-2.
 */
public class AppEnableRequestDTO  extends BaseRequestDTO {
    @ApiModelProperty(value = "1:启用，0:禁用")
    private Boolean enabled;

    /*@NotNull
    @NotEmpty
    private String code;*/

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppEnableRequestDTO that = (AppEnableRequestDTO) o;

        return enabled != null ? enabled.equals(that.enabled) : that.enabled == null;
    }

    @Override
    public int hashCode() {
        return enabled != null ? enabled.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "AppEnableRequestDTO{" +
                "enabled=" + enabled +
                '}';
    }
}
