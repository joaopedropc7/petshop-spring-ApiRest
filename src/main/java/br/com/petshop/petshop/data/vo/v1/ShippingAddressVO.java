package br.com.petshop.petshop.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dozermapper.core.Mapping;

import java.util.Objects;

public class ShippingAddressVO {

    @JsonProperty("id")
    @Mapping("id")
    private Long key;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String number;
    private String localidade;
    private String uf;

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShippingAddressVO that = (ShippingAddressVO) o;
        return Objects.equals(key, that.key) && Objects.equals(cep, that.cep) && Objects.equals(logradouro, that.logradouro) && Objects.equals(complemento, that.complemento) && Objects.equals(bairro, that.bairro) && Objects.equals(number, that.number) && Objects.equals(localidade, that.localidade) && Objects.equals(uf, that.uf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, cep, logradouro, complemento, bairro, number, localidade, uf);
    }
}
