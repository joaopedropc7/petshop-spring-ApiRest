package br.com.petshop.petshop.controller;

import br.com.petshop.petshop.DTOS.OrderDTO;
import br.com.petshop.petshop.data.vo.v1.OrderVO;
import br.com.petshop.petshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping
    public OrderVO createOrder(@RequestBody OrderDTO dto){
        return service.createOrder(dto);
    }

    @GetMapping
    public List<OrderVO> findAllOrders(){
        return service.findAll();
    }

    @GetMapping(value = "/{id}")
    public OrderVO findById(@PathVariable(value = "id") Long id){
        return service.findById(id);
    }

    @PutMapping(value = "/{id}")
    public OrderVO cancellOrder(Long id){
        return service.cancelOrder(id);
    }

    //@PutMapping(name = "/payment", value = "/{id}")
    public OrderVO paymentApproved(Long id){
        return service.paymentApproved(id);
    }

    @RequestMapping(name = "/dispatched")
    @PutMapping(value = "/{id}")
    public OrderVO orderDispatched(Long id){
        return service.orderDispatched(id);
    }
}
