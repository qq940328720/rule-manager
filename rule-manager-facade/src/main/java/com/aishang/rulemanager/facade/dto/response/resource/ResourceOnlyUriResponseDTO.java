package com.aishang.rulemanager.facade.dto.response.resource;

import java.util.Objects;

public class ResourceOnlyUriResponseDTO {

    private String uri;

    @Override
    public String toString() {
        return "ResourceOnlyUriResponseDTO{" +
                "uri='" + uri + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceOnlyUriResponseDTO that = (ResourceOnlyUriResponseDTO) o;
        return Objects.equals(uri, that.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uri);
    }

    public String getUri() {

        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public ResourceOnlyUriResponseDTO() {

    }

    public ResourceOnlyUriResponseDTO(String uri) {

        this.uri = uri;
    }
}
