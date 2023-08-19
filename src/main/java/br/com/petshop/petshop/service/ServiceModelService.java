package br.com.petshop.petshop.service;

import br.com.petshop.petshop.data.vo.v1.ServiceVO;
import br.com.petshop.petshop.mapper.DozerMapper;
import br.com.petshop.petshop.model.ServiceModel;
import br.com.petshop.petshop.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceModelService {


    @Autowired
    private ServiceRepository repository;

    public ServiceVO findById(Long id){
        var entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Not records found this id"));
        var vo = DozerMapper.parseObject(entity, ServiceVO.class);
        return vo;
    }

    public List<ServiceVO> findAll(){
        List<ServiceModel> entities = repository.findAll();
        var vo = DozerMapper.parseListObjects(entities, ServiceVO.class);
        return vo;
    }

    public ServiceVO create(ServiceVO serviceVO){
        var entity = DozerMapper.parseObject(serviceVO, ServiceModel.class);
        var vo = DozerMapper.parseObject(repository.save(entity), ServiceVO.class);
        return vo;
    }

    public ServiceVO update(ServiceVO serviceVO){
        var entity = repository.findById(serviceVO.getKey()).orElseThrow(() -> new RuntimeException("No records found for this id"));

        entity.setName(serviceVO.getName());
        entity.setDescription(serviceVO.getDescription());
        entity.setImage(serviceVO.getImage());
        entity.setValue(serviceVO.getValue());

        var vo = DozerMapper.parseObject(repository.save(entity), ServiceVO.class);
        return vo;
    }

    public ResponseEntity<?> delete(Long id){
        var entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Not records found this id"));
        repository.delete(entity);
        return ResponseEntity.ok().build();
    }
}
