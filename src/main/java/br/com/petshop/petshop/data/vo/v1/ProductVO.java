package br.com.petshop.petshop.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dozermapper.core.Mapping;

import java.util.Objects;

public class ProductVO {

    @JsonProperty("id")
    @Mapping("id")
    private Long key;
    private String name;
    private String description;
    private String image;
    private Integer quantity;
    private Long value;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductVO productVO = (ProductVO) o;
        return Objects.equals(key, productVO.key) && Objects.equals(name, productVO.name) && Objects.equals(description, productVO.description) && Objects.equals(image, productVO.image) && Objects.equals(quantity, productVO.quantity) && Objects.equals(value, productVO.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, name, description, image, quantity, value);
    }
}
