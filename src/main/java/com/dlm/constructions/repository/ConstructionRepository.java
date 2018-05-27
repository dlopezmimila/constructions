package com.dlm.constructions.repository;

import com.dlm.constructions.model.Construction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

//conel extends me hace todas las funciones de CRUD

public interface ConstructionRepository extends JpaRepository <Construction,Long>, JpaSpecificationExecutor  {
}
