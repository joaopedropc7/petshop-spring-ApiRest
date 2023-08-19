package br.com.petshop.petshop.repositories;

import br.com.petshop.petshop.model.FormularioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormularioRepository extends JpaRepository<FormularioModel, Long> {
}
