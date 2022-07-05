package com.fundatec.lp1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fundatec.lp1.models.Banco;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Integer> {

}
