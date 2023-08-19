package br.com.petshop.petshop.service;

import br.com.petshop.petshop.data.vo.v1.ProductVO;
import br.com.petshop.petshop.mapper.DozerMapper;
import br.com.petshop.petshop.model.ProductModel;
import br.com.petshop.petshop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public ProductVO findById(Long id){
        var entity = repository.findById(id).orElseThrow(() -> new RuntimeException("No records found for this id"));
        var vo = DozerMapper.parseObject(entity, ProductVO.class);
        return vo;
    }

    public List<ProductVO> findAll(){
        var entity = repository.findAll();
        var vo = DozerMapper.parseListObjects(entity, ProductVO.class);
        return vo;
    }

    public ProductVO create(ProductVO productVO){
        var entity = DozerMapper.parseObject(productVO, ProductModel.class);
        var vo = DozerMapper.parseObject(repository.save(entity), ProductVO.class);
        return vo;
    }

    public ProductVO update(ProductVO productVO){
        var entity = repository.findById(productVO.getKey()).orElseThrow(() -> new RuntimeException("No records found for this id"));

        entity.setName(productVO.getName());
        entity.setDescription(productVO.getDescription());
        entity.setImage(productVO.getImage());
        entity.setValue(entity.getValue());

        var vo = DozerMapper.parseObject(repository.save(entity), ProductVO.class);
        return vo;
    }

    public void delete(Long id){
        var entity = repository.findById(id).orElseThrow(() -> new RuntimeException("No records found for this id"));
        repository.deleteById(id);
    }

}
