package br.com.petshop.petshop.service;

import br.com.petshop.petshop.data.vo.v1.ClientVO;
import br.com.petshop.petshop.data.vo.v1.FormularioVO;
import br.com.petshop.petshop.mapper.DozerMapper;
import br.com.petshop.petshop.model.ClientModel;
import br.com.petshop.petshop.model.FormularioModel;
import br.com.petshop.petshop.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public ClientVO findById(Long id){
        var entity = repository.findById(id).orElseThrow(() -> new RuntimeException("No records found for this id"));
        var vo = DozerMapper.parseObject(entity, ClientVO.class);
        return vo;
    }

    public List<ClientVO> findAll(){
        var entity = repository.findAll();
        var vo = DozerMapper.parseListObjects(entity, ClientVO.class);
        return vo;
    }

    public ClientVO create(ClientVO clientVO){
        var entity = DozerMapper.parseObject(clientVO, ClientModel.class);
        var vo = DozerMapper.parseObject(repository.save(entity), ClientVO.class);
        return vo;
    }

    public ClientVO update(ClientVO clientVO){
        var entity = repository.findById(clientVO.getKey()).orElseThrow(() -> new RuntimeException("No records found for this id"));

        entity.setFullName(clientVO.getFullName());
        entity.setCpf(clientVO.getCpf());
        entity.setShippingAdress(clientVO.getShippingAdress());

        var vo = DozerMapper.parseObject(repository.save(entity), ClientVO.class);
        return vo;
    }

    public void delete(Long id){
        var entity = repository.findById(id).orElseThrow(() -> new RuntimeException("No records found for this id"));
        repository.deleteById(id);
    }

}
