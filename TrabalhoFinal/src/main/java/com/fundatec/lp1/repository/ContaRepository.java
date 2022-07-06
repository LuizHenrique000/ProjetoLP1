package com.fundatec.lp1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fundatec.lp1.models.Conta;

public interface ContaRepository extends JpaRepository<Conta, Integer> {

}
