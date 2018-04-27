package com.aishang.rulemanager.facade.dto.request.user;

import com.aishang.rulemanager.facade.dto.request.base.BaseRequestDTO;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by mx on 18-3-2.
 */
public class UserEnableRequestDTO extends UserBaseRequestDTO {
    @ApiModelProperty(value = "true:启用，false:禁用")
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

        UserEnableRequestDTO that = (UserEnableRequestDTO) o;

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
