package br.com.petshop.petshop.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dozermapper.core.Mapping;

import java.util.Objects;

public class ServiceVO {

    @JsonProperty("id")
    @Mapping("id")
    private Long key;
    private String name;
    private String description;
    private Double value;
    private String image;

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceVO serviceVO = (ServiceVO) o;
        return Objects.equals(key, serviceVO.key) && Objects.equals(name, serviceVO.name) && Objects.equals(description, serviceVO.description) && Objects.equals(value, serviceVO.value) && Objects.equals(image, serviceVO.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, name, description, value, image);
    }
}
