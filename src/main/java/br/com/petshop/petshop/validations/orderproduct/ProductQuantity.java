package br.com.petshop.petshop.validations.orderproduct;

import br.com.petshop.petshop.exceptions.ValidationException;
import br.com.petshop.petshop.model.ProductModel;
import org.springframework.stereotype.Component;

@Component
public class ProductQuantity implements OrderProductValidation{

    @Override
    public void validar(ProductModel productModel) {
        if (productModel.getQuantity() == 0 || productModel.getQuantity() < 0){
            throw new ValidationException("Esse produto não tem estoque");
        }
    }
}
