package br.com.petshop.petshop.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dozermapper.core.Mapping;

import java.util.Objects;

public class FormularioVO {

    @Mapping("id")
    @JsonProperty("id")
    private Long key;
    private String name;
    private String email;
    private String message;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormularioVO that = (FormularioVO) o;
        return Objects.equals(key, that.key) && Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, name, email, message);
    }
}
