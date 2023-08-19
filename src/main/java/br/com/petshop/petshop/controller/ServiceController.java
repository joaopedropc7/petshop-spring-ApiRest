package br.com.petshop.petshop.controller;

import br.com.petshop.petshop.data.vo.v1.ServiceVO;
import br.com.petshop.petshop.service.ServiceModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/service/v1")
public class ServiceController {

    @Autowired
    private ServiceModelService service;

    @GetMapping(value = "/{id}")
    public ServiceVO findById(@PathVariable(value = "id") Long id){
        return service.findById(id);
    }

    @GetMapping
    public List<ServiceVO> findAll(){
        return service.findAll();
    }

    @PostMapping
    public ServiceVO create(@RequestBody ServiceVO serviceVO){
        return service.create(serviceVO);
    }

    @PutMapping
    public ServiceVO update(@RequestBody ServiceVO serviceVO){
        return service.update(serviceVO);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        service.delete(id);
    }
}
