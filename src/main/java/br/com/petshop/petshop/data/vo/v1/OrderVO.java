package br.com.petshop.petshop.data.vo.v1;

import br.com.petshop.petshop.model.ClientModel;
import br.com.petshop.petshop.model.Enums.OrderStatus;
import br.com.petshop.petshop.model.ProductModel;
import br.com.petshop.petshop.model.ShippingAdressModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dozermapper.core.Mapping;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

public class OrderVO {

    @Mapping("id")
    @JsonProperty("id")
    private Long key;
    private ClientModel clientModel;
    private ProductModel productModel;
    private Date orderDate;
    private ShippingAdressModel orderAdress;
    private OrderStatus orderStatus;

    public OrderVO(){}
    
    public OrderVO(ProductModel product, ClientModel client){
        this.clientModel = client;
        this.productModel = product;
        this.orderDate = new Date();
        this.orderAdress = client.getShippingAdress();
        this.orderStatus = OrderStatus.waitingPayment;
    }



    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public ClientModel getClientModel() {
        return clientModel;
    }

    public void setClientModel(ClientModel clientModel) {
        this.clientModel = clientModel;
    }

    public ProductModel getProductModel() {
        return productModel;
    }

    public void setProductModel(ProductModel productModel) {
        this.productModel = productModel;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public ShippingAdressModel getOrderAdress() {
        return orderAdress;
    }

    public void setOrderAdress(ShippingAdressModel orderAdress) {
        this.orderAdress = orderAdress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderVO orderVO = (OrderVO) o;
        return Objects.equals(key, orderVO.key) && Objects.equals(clientModel, orderVO.clientModel) && Objects.equals(productModel, orderVO.productModel) && Objects.equals(orderDate, orderVO.orderDate) && Objects.equals(orderAdress, orderVO.orderAdress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, clientModel, productModel, orderDate, orderAdress);
    }
}
