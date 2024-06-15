package com.projeto.ProvaIII.service;

import com.projeto.ProvaIII.model.Departamento;
import com.projeto.ProvaIII.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    @Autowired
    DepartamentoRepository repository;

    public Departamento save(Departamento departamento){
        return repository.save(departamento);
    }

    public Departamento update(Departamento departamento){
        return repository.save(departamento);
    }

    public void remove(Departamento departamento){
        repository.delete(departamento);
    }

    public Departamento findById(Integer id){
        return repository.findById(id).orElse(null);
    }

    public List<Departamento> listAll(){
        return repository.findAll();
    }

    public Departamento findByNome(String nome){
        return repository.findByNome(nome);
    }
}
