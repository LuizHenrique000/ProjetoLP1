package com.fundatec.lp1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fundatec.lp1.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
