package com.aishang.rulemanager.facade.dto.info.resource;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;

@JsonDeserialize(using = ResourceInfo.ResourceInfoDeserialize.class)
public class ResourceInfo {

    private String appCode;

    private String code;

    private String parentCode;

    private Integer type;

    private Integer order;

    private Integer visible;

    private Integer enabled;

    private String uri;

    private String icon;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
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

    public static class ResourceInfoDeserialize extends JsonDeserializer<ResourceInfo> {

        @Override
        public ResourceInfo deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            if (null != jsonParser) {
                ObjectCodec objectCodec = jsonParser.getCodec();
                JsonNode jsonNode = objectCodec.readTree(jsonParser);
                ResourceInfo resourceInfo = new ResourceInfo();
                resourceInfo.setAppCode(jsonNode.path("appCode").asText());
                resourceInfo.setCode(jsonNode.path("code").asText());
                resourceInfo.setParentCode(jsonNode.path("parentCode").asText());
                resourceInfo.setType(jsonNode.path("type").asInt());
                resourceInfo.setOrder(jsonNode.path("order").asInt());
                resourceInfo.setVisible(jsonNode.path("visible").asInt());
                resourceInfo.setEnabled(jsonNode.path("enabled").asInt());
                resourceInfo.setUri(jsonNode.path("uri").asText());
                resourceInfo.setIcon(jsonNode.path("icon").asText());
                resourceInfo.setDescription(jsonNode.path("description").asText());
                return resourceInfo;
            }
            return null;
        }
    }


    @Override
    public String toString() {
        return "ResourceInfo{" +
                "appCode='" + appCode + '\'' +
                ", code='" + code + '\'' +
                ", parentCode='" + parentCode + '\'' +
                ", type=" + type +
                ", order=" + order +
                ", visible=" + visible +
                ", enabled=" + enabled +
                ", uri='" + uri + '\'' +
                ", icon='" + icon + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
