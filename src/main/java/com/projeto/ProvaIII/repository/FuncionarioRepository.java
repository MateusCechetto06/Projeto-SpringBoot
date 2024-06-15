package com.projeto.ProvaIII.repository;

import com.projeto.ProvaIII.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    public Funcionario findByNome(String nome);
    public List<Funcionario> findByIdade(Integer idade);
}
