package br.com.petshop.petshop.repositories;

import br.com.petshop.petshop.model.ServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceModel, Long> {
}
