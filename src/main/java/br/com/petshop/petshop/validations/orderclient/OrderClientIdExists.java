package br.com.petshop.petshop.validations.orderclient;

import br.com.petshop.petshop.exceptions.ValidationException;
import br.com.petshop.petshop.model.ClientModel;
import br.com.petshop.petshop.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderClientIdExists implements OrderClientValidation{

    @Autowired
    private ClientRepository repository;

    @Override
    public void validar(ClientModel clientModel) {
        if (!repository.existsById(clientModel.getId())){
            throw new ValidationException("Este cliente não está cadastrado!");
        }
    }
}
