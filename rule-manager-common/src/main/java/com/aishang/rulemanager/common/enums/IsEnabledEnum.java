package com.aishang.rulemanager.common.enums;

/**
 * Created by ylj on 18-3-1.
 */
public enum IsEnabledEnum {

    ENABLE(1, "启用"),
    UNABLE(0, "禁用");

    private String name;
    private Integer value;
    private String displayName;

    IsEnabledEnum(Integer value, String name) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
