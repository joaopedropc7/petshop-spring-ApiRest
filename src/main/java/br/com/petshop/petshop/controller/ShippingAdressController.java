package br.com.petshop.petshop.controller;

import br.com.petshop.petshop.client.ViaCepClient;
import br.com.petshop.petshop.model.ShippingAdressModel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/endereco")
public class ShippingAdressController {

    @Autowired
    ViaCepClient viaCepClient;

    //Requisição API VIACEP, APÓS PREENCHER O CAMPO CEP PREENCHER OS OUTROS CAMPOS AUTOMATICAMENTE
    @GetMapping("/{cep}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ShippingAdressModel> getCharacterById(@PathVariable String cep) {
        System.out.println(cep);
        return viaCepClient.findByCep(cep);
    }





}
