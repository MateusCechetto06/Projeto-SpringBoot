package com.projeto.ProvaIII.repository;

import com.projeto.ProvaIII.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
    public Departamento findByNome(String nome);
}
