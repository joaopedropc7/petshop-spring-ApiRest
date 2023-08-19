package br.com.petshop.petshop.validations.orderproduct;

import br.com.petshop.petshop.exceptions.ValidationException;
import br.com.petshop.petshop.model.ProductModel;
import br.com.petshop.petshop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductExists implements OrderProductValidation{

    @Autowired
    private ProductRepository repository;

    @Override
    public void validar(ProductModel productModel) {
        if (!repository.existsById(productModel.getId())){
            throw new ValidationException("Esse produto não existe!");
        }
    }
}
