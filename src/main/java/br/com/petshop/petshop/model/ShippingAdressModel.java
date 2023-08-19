package br.com.petshop.petshop.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "shippingadress")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ShippingAdressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String number;
    private String localidade;
    private String uf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        ShippingAdressModel that = (ShippingAdressModel) o;
        return Objects.equals(id, that.id) && Objects.equals(cep, that.cep) && Objects.equals(logradouro, that.logradouro) && Objects.equals(complemento, that.complemento) && Objects.equals(bairro, that.bairro) && Objects.equals(number, that.number) && Objects.equals(localidade, that.localidade) && Objects.equals(uf, that.uf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cep, logradouro, complemento, bairro, number, localidade, uf);
    }
}
