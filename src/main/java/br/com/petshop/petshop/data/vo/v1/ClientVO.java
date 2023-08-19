package br.com.petshop.petshop.data.vo.v1;

import br.com.petshop.petshop.model.ShippingAdressModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dozermapper.core.Mapping;

import java.util.Objects;

public class ClientVO {

    @Mapping("id")
    @JsonProperty("id")
    private Long key;
    private String fullName;
    private String gender;
    private ShippingAdressModel shippingAdress;
    private String cpf;

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ShippingAdressModel getShippingAdress() {
        return shippingAdress;
    }

    public void setShippingAdress(ShippingAdressModel shippingAdress) {
        this.shippingAdress = shippingAdress;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientVO clientVO = (ClientVO) o;
        return Objects.equals(key, clientVO.key) && Objects.equals(fullName, clientVO.fullName) && Objects.equals(gender, clientVO.gender) && Objects.equals(shippingAdress, clientVO.shippingAdress) && Objects.equals(cpf, clientVO.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, fullName, gender, shippingAdress, cpf);
    }
}
