package com.projeto.ProvaIII.resource;

import com.projeto.ProvaIII.model.Funcionario;
import com.projeto.ProvaIII.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioResource {

    @Autowired
    FuncionarioService service;

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> findById(@PathVariable Integer id){
        Funcionario funcionario = service.findById(id);

        if(funcionario == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(funcionario);
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> listAll(){
        List<Funcionario> funcionarios = service.listAll();

        if(funcionarios.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping("nome/{nome}")
    public ResponseEntity<Funcionario> findByNome(@PathVariable String nome){
        Funcionario funcionario = service.findByNome(nome);

        if(funcionario == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(funcionario);
    }

    @GetMapping("idade/{idade}")
    public ResponseEntity<List<Funcionario>> findByIdade(@PathVariable Integer idade){
        List<Funcionario> funcionarios = service.findByIdade(idade);

        if(funcionarios.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(funcionarios);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario save(@RequestBody Funcionario funcionario){
        return service.save(funcionario);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Funcionario funcionario){
        Funcionario f = service.findById(funcionario.getId());
        if(f == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel localizar o departamento para exclusão");
        }

        service.remove(funcionario);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Funcionario funcionario){
        Funcionario newFuncionario = service.findById(id);
        if(newFuncionario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel localizar o departamento para atualização");
        }
        funcionario.setId(newFuncionario.getId());
        service.update(funcionario);
        return ResponseEntity.ok().build();
    }
}
