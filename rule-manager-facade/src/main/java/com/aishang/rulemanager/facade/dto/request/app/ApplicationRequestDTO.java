package com.aishang.rulemanager.facade.dto.request.app;

import com.aishang.rulemanager.facade.dto.request.base.BaseRequestDTO;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class ApplicationRequestDTO extends BaseRequestDTO {

    @ApiModelProperty(value = "系统名称")
    @NotEmpty
    @NotNull
    private String name;

    @ApiModelProperty(value = "URL")
    @NotEmpty
    @NotNull
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApplicationRequestDTO that = (ApplicationRequestDTO) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return url != null ? url.equals(that.url) : that.url == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ApplicationRequestDTO{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
