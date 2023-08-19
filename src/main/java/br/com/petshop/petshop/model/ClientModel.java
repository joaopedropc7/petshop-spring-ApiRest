package br.com.petshop.petshop.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "client")
public class ClientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String gender;
    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private ShippingAdressModel shippingAdress;
    private String cpf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        ClientModel that = (ClientModel) o;
        return Objects.equals(id, that.id) && Objects.equals(fullName, that.fullName) && Objects.equals(gender, that.gender) && Objects.equals(shippingAdress, that.shippingAdress) && Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, gender, shippingAdress, cpf);
    }
}
