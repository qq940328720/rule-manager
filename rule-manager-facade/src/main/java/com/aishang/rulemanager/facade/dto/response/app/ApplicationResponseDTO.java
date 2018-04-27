package com.aishang.rulemanager.facade.dto.response.app;

import com.aishang.rulemanager.facade.dto.info.app.ApplicationInfo;
import com.aishang.rulemanager.facade.dto.response.base.BaseResponseDTO;

import java.util.List;

public class ApplicationResponseDTO extends BaseResponseDTO {

    private List<ApplicationInfo> list;

    public ApplicationResponseDTO() {

    }

    public List<ApplicationInfo> getList() {
        return list;
    }

    public void setList(List<ApplicationInfo> list) {
        this.list = list;
    }

    /*    private String code;
        private String name;
        private String url;
        private Long createdAt;
        private Long updatedAt;
        private Boolean enabled;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

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

        public Long getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Long createdAt) {
            this.createdAt = createdAt;
        }

        public Long getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Long updatedAt) {
            this.updatedAt = updatedAt;
        }

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

            ApplicationResponseDTO that = (ApplicationResponseDTO) o;

            if (list != null ? !list.equals(that.list) : that.list != null) return false;
            if (code != null ? !code.equals(that.code) : that.code != null) return false;
            if (name != null ? !name.equals(that.name) : that.name != null) return false;
            if (url != null ? !url.equals(that.url) : that.url != null) return false;
            if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
            if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;
            return enabled != null ? enabled.equals(that.enabled) : that.enabled == null;
        }

        @Override
        public int hashCode() {
            int result = list != null ? list.hashCode() : 0;
            result = 31 * result + (code != null ? code.hashCode() : 0);
            result = 31 * result + (name != null ? name.hashCode() : 0);
            result = 31 * result + (url != null ? url.hashCode() : 0);
            result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
            result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
            result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
            return result;
        }

        @Override
            public String toString() {
                return "ApplicationResponseDTO{" +
                        "code='" + code + '\'' +
                        ", name='" + name + '\'' +
                        ", url='" + url + '\'' +
                        ", createdAt=" + createdAt +
                        ", updatedAt=" + updatedAt +
                        ", enabled=" + enabled +
                        '}';
            }

        public ApplicationResponseDTO(String code, String name, String url, Long createdAt, Long updatedAt, Boolean enabled) {
            this.code = code;
            this.name = name;
            this.url = url;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
            this.enabled = enabled;
        }*/
}

