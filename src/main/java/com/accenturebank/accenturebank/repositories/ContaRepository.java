package com.accenturebank.accenturebank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenturebank.accenturebank.models.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
}
