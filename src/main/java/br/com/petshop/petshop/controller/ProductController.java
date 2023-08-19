package br.com.petshop.petshop.controller;

import br.com.petshop.petshop.data.vo.v1.ProductVO;
import br.com.petshop.petshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product/v1")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(value = "/{id}")
    public ProductVO findById(@PathVariable(value = "id") Long id){
        return service.findById(id);
    }

    @GetMapping
    public List<ProductVO> findAll(){
        return service.findAll();
    }

    @PostMapping
    public ProductVO create(@RequestBody ProductVO productVO){
        return service.create(productVO);
    }

    @PutMapping
    public ProductVO update(@RequestBody ProductVO productVO){
        return service.update(productVO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
