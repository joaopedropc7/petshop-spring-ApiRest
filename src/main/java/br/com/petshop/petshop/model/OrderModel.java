package br.com.petshop.petshop.model;

import br.com.petshop.petshop.model.Enums.OrderStatus;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Entity
@Table(name = "pedidos")
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientModel clientModel;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductModel productModel;
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @OneToOne
    @JoinColumn(name = "order_adress_id")
    private ShippingAdressModel orderAdress;
    private OrderStatus orderStatus;

    public OrderModel(){}

    public OrderModel(ProductModel product,ClientModel client) {
        this.clientModel = client;
        this.productModel = product;
        this.orderDate = new Date();
        this.orderAdress = client.getShippingAdress();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public OrderStatus getOrderStatus() {

        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderModel that = (OrderModel) o;
        return Objects.equals(id, that.id) && Objects.equals(clientModel, that.clientModel) && Objects.equals(productModel, that.productModel) && Objects.equals(orderDate, that.orderDate) && Objects.equals(orderAdress, that.orderAdress) && orderStatus == that.orderStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientModel, productModel, orderDate, orderAdress, orderStatus);
    }
}
