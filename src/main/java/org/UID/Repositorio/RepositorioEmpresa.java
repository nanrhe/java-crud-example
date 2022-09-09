package org.UID.Repositorio;

import org.UID.Entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEmpresa extends JpaRepository <Empresa, Long>{

}
