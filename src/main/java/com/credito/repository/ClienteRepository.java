package com.credito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.credito.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
