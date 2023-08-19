package br.com.petshop.petshop.service;

import br.com.petshop.petshop.DTOS.OrderDTO;
import br.com.petshop.petshop.data.vo.v1.ClientVO;
import br.com.petshop.petshop.data.vo.v1.OrderVO;
import br.com.petshop.petshop.mapper.DozerMapper;
import br.com.petshop.petshop.model.Enums.OrderStatus;
import br.com.petshop.petshop.model.OrderModel;
import br.com.petshop.petshop.repositories.ClientRepository;
import br.com.petshop.petshop.repositories.OrderRepository;
import br.com.petshop.petshop.repositories.ProductRepository;
import br.com.petshop.petshop.validations.orderclient.OrderClientValidation;
import br.com.petshop.petshop.validations.orderproduct.OrderProductValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private List<OrderProductValidation> orderProductValidations;

    @Autowired
    private List<OrderClientValidation> orderClientValidations;

    public OrderVO createOrder(OrderDTO dto){
        var product = productRepository.findById(dto.idProduct()).orElseThrow(() -> new RuntimeException("No records found for this id"));
        orderProductValidations.forEach(v -> v.validar(product));
        var client = clientRepository.findById(dto.idClient()).orElseThrow(() -> new RuntimeException("No records found for this id"));
        orderClientValidations.forEach(v -> v.validar(client));

        OrderVO orderVO = new OrderVO(product, client);
        var entity = DozerMapper.parseObject(orderVO, OrderModel.class);
        var vo = DozerMapper.parseObject(orderRepository.save(entity), OrderVO.class);
        product.setQuantity(product.getQuantity() - 1);
        productRepository.save(product);
        return vo;
    }

    public List<OrderVO> findAll() {
        var entity = orderRepository.findAll();
        var vo = DozerMapper.parseListObjects(entity, OrderVO.class);
        return vo;
    }

    public OrderVO findById(Long id){
        var entity = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("No records found for this id"));
        var vo = DozerMapper.parseObject(entity, OrderVO.class);
        return vo;
    }

    public OrderVO cancelOrder(Long id){
        var entity = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("No records found for this id"));
        entity.setOrderStatus(OrderStatus.cancelled);
        orderRepository.save(entity);
        var vo = DozerMapper.parseObject(entity, OrderVO.class);
        return vo;
    }

    public OrderVO paymentApproved(Long id){
        var entity = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("No records found for this id"));
        entity.setOrderStatus(OrderStatus.paymentApproved);
        orderRepository.save(entity);
        var vo = DozerMapper.parseObject(entity, OrderVO.class);
        return vo;
    }

    public OrderVO orderDispatched(Long id){
        var entity = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("No records found for this id"));
        entity.setOrderStatus(OrderStatus.orderDispatched);
        orderRepository.save(entity);
        var vo = DozerMapper.parseObject(entity, OrderVO.class);
        return vo;
    }

    public OrderVO orderDelivered(Long id){
        var entity = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("No records found for this id"));
        entity.setOrderStatus(OrderStatus.delivered);
        orderRepository.save(entity);
        var vo = DozerMapper.parseObject(entity, OrderVO.class);
        return vo;
    }

}
