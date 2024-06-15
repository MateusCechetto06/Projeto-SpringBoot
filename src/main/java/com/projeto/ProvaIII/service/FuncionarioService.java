package com.projeto.ProvaIII.service;

import com.projeto.ProvaIII.model.Funcionario;
import com.projeto.ProvaIII.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository repository;

    public Funcionario save(Funcionario funcionario){
        return repository.save(funcionario);
    }

    public Funcionario update(Funcionario funcionario){
        return repository.save(funcionario);
    }

    public void remove(Funcionario funcionario){
        repository.delete(funcionario);
    }

    public Funcionario findById(Integer id){
        return repository.findById(id).orElse(null);
    }

    public List<Funcionario> listAll(){
        return repository.findAll();
    }

    public Funcionario findByNome(String nome){
        return repository.findByNome(nome);
    }

    public List<Funcionario> findByIdade(Integer idade){
        return repository.findByIdade(idade);
    }
}
