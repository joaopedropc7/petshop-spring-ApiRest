package br.com.petshop.petshop.controller;

import br.com.petshop.petshop.data.vo.v1.ClientVO;
import br.com.petshop.petshop.data.vo.v1.FormularioVO;
import br.com.petshop.petshop.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping(value = "/{id}")
    public ClientVO findById(@PathVariable(value = "id") Long id){
        return service.findById(id);
    }

    @GetMapping
    public List<ClientVO> findAll(){
        return service.findAll();
    }

    @PostMapping
    public ClientVO create(@RequestBody ClientVO clientVO){
        return service.create(clientVO);
    }

    @PutMapping
    public ClientVO update(@RequestBody ClientVO clientVO){
        return service.update(clientVO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
