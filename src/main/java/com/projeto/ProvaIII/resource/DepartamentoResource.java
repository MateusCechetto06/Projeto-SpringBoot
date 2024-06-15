package com.projeto.ProvaIII.resource;

import com.projeto.ProvaIII.model.Departamento;
import com.projeto.ProvaIII.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoResource {

    @Autowired
    DepartamentoService service;

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> findById(@PathVariable Integer id){
        Departamento departamento = service.findById(id);

        if(departamento == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(departamento);
    }

    @GetMapping
    public ResponseEntity<List<Departamento>> listAll(){
        List<Departamento> departamentos = service.listAll();

        if(departamentos.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(departamentos);
    }

    @GetMapping("nome/{nome}")
    public ResponseEntity<Departamento> findByNome(@PathVariable String nome){
        Departamento departamento = service.findByNome(nome);

        if(departamento == null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(departamento);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Departamento save(@RequestBody Departamento departamento){
         return service.save(departamento);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Departamento departamento){
        Departamento d = service.findById(departamento.getId());
        if(d == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel localizar o departamento para exclusão");
        }

        service.remove(departamento);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Departamento departamento){
        Departamento newDepartamento = service.findById(id);
        if(newDepartamento == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel localizar o departamento para atualização");
        }
        departamento.setId(newDepartamento.getId());
        service.update(departamento);
        return ResponseEntity.ok().build();
    }

}
