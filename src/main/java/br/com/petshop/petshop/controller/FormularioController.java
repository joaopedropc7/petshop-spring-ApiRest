package br.com.petshop.petshop.controller;

import br.com.petshop.petshop.data.vo.v1.FormularioVO;
import br.com.petshop.petshop.data.vo.v1.ProductVO;
import br.com.petshop.petshop.service.FormularioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/forms")
@RestController
public class FormularioController {

    @Autowired
    private FormularioService service;


    @GetMapping(value = "/{id}")
    public FormularioVO findById(@PathVariable(value = "id") Long id){
        return service.findById(id);
    }

    @GetMapping
    public List<FormularioVO> findAll(){
        return service.findAll();
    }

    @PostMapping
    public FormularioVO create(@RequestBody FormularioVO formularioVO){
        return service.create(formularioVO);
    }

    @PutMapping
    public FormularioVO update(@RequestBody FormularioVO formularioVO){
        return service.update(formularioVO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
