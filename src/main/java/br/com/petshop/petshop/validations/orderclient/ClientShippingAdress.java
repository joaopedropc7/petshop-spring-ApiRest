package br.com.petshop.petshop.validations.orderclient;

import br.com.petshop.petshop.exceptions.ValidationException;
import br.com.petshop.petshop.model.ClientModel;
import org.springframework.stereotype.Component;

@Component
public class ClientShippingAdress implements OrderClientValidation{
    @Override
    public void validar(ClientModel clientModel) {
        if (clientModel.getShippingAdress() == null){
            throw new ValidationException("É necessário cadastrar um endereço para finalizar o pedido");
        }
    }
}
