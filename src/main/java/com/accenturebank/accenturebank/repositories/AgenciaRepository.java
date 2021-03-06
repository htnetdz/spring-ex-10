package com.accenturebank.accenturebank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenturebank.accenturebank.models.Agencia;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Long> {
}
