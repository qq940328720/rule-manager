package com.aishang.rulemanager.facade.dto.response.app;

import com.aishang.rulemanager.facade.dto.info.app.ApplicationInfo;

/**
 * Created by mx on 18-3-2.
 */
public class GetAppResponseDTO {

    private ApplicationInfo appInfo;

    public ApplicationInfo getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(ApplicationInfo appInfo) {
        this.appInfo = appInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GetAppResponseDTO that = (GetAppResponseDTO) o;

        return appInfo != null ? appInfo.equals(that.appInfo) : that.appInfo == null;
    }

    @Override
    public int hashCode() {
        return appInfo != null ? appInfo.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "GetAppResponseDTO{" +
                "appInfo=" + appInfo +
                '}';
    }
}
