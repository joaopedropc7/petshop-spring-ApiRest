package br.com.petshop.petshop.service;

import br.com.petshop.petshop.data.vo.v1.FormularioVO;
import br.com.petshop.petshop.data.vo.v1.ProductVO;
import br.com.petshop.petshop.mapper.DozerMapper;
import br.com.petshop.petshop.model.FormularioModel;
import br.com.petshop.petshop.model.ProductModel;
import br.com.petshop.petshop.repositories.FormularioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormularioService {

    @Autowired
    private FormularioRepository repository;

    public FormularioVO findById(Long id){
        var entity = repository.findById(id).orElseThrow(() -> new RuntimeException("No records found for this id"));
        var vo = DozerMapper.parseObject(entity, FormularioVO.class);
        return vo;
    }

    public List<FormularioVO> findAll(){
        var entity = repository.findAll();
        var vo = DozerMapper.parseListObjects(entity, FormularioVO.class);
        return vo;
    }

    public FormularioVO create(FormularioVO formularioVO){
        var entity = DozerMapper.parseObject(formularioVO, FormularioModel.class);
        var vo = DozerMapper.parseObject(repository.save(entity), FormularioVO.class);
        return vo;
    }

    public FormularioVO update(FormularioVO formularioVO){
        var entity = repository.findById(formularioVO.getKey()).orElseThrow(() -> new RuntimeException("No records found for this id"));

        entity.setName(formularioVO.getName());
        entity.setEmail(formularioVO.getEmail());
        entity.setMessage(formularioVO.getMessage());

        var vo = DozerMapper.parseObject(repository.save(entity), FormularioVO.class);
        return vo;
    }

    public void delete(Long id){
        var entity = repository.findById(id).orElseThrow(() -> new RuntimeException("No records found for this id"));
        repository.deleteById(id);
    }
}
