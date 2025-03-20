package com.trabalho.ifood.resources;



import com.trabalho.ifood.domains.Pessoa;
import com.trabalho.ifood.domains.dtos.PessoaDTO;
import com.trabalho.ifood.services.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaResource {

    @Autowired
    private PessoaService PessoaService;

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> findAll(){
        return ResponseEntity.ok().body(PessoaService.findAll());

    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaDTO> findById(@PathVariable Integer id){
        Pessoa obj = this.PessoaService.findbyId(id);
        return ResponseEntity.ok().body(new PessoaDTO(obj));
    }


    @PostMapping
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaDTO dto){
        Pessoa Pessoa = PessoaService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(Pessoa.getIdPessoa()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PessoaDTO> update(@PathVariable Integer id, @Valid @RequestBody PessoaDTO objDto){
        Pessoa Obj = PessoaService.update(id, objDto);
        return ResponseEntity.ok().body(new PessoaDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PessoaDTO> delete(@PathVariable Integer id){
        PessoaService.delete(id);
        return  ResponseEntity.noContent().build();
    }

}
