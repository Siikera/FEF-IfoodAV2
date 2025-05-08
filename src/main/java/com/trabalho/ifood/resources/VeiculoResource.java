package com.trabalho.ifood.resources;

import com.trabalho.ifood.domains.Cliente;
import com.trabalho.ifood.domains.Veiculo;
import com.trabalho.ifood.domains.dtos.ClienteDTO;
import com.trabalho.ifood.domains.dtos.VeiculoDTO;
import com.trabalho.ifood.services.ClienteService;
import com.trabalho.ifood.services.VeiculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/veiculo")
@Tag(name = "Veiculos", description = "Api para gerenciamento de veiculos")
public class VeiculoResource {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    @Operation(summary = "Listar todos os veiculos", description = "Retorna uma lista com todos os veiculos cadastrados")
    public ResponseEntity<List<VeiculoDTO>> findAll(){ return ResponseEntity.ok().body(veiculoService.findAll());

    }
    @GetMapping(value = "/{id}")
    @Operation(summary = "Busca o veiculo por id", description = "Realiza a busca de um veiculo cadastrado por id")
    public ResponseEntity<VeiculoDTO> findById(@PathVariable Long id){
        Veiculo obj = this.veiculoService.findbyId(id);
        return ResponseEntity.ok().body(new VeiculoDTO(obj));
    }

    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<VeiculoDTO> findById(@PathVariable String cpf){
        Veiculo obj = this.veiculoService.findbyCpf(cpf);
        return ResponseEntity.ok().body(new VeiculoDTO(obj));
    }


    @PostMapping
    public ResponseEntity<VeiculoDTO> create(@Valid @RequestBody VeiculoDTO dto){
        Veiculo Veiculo = veiculoService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(Veiculo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<VeiculoDTO> update(@PathVariable Long id, @Valid @RequestBody VeiculoDTO objDto){
        Veiculo Obj = veiculoService.update(id, objDto);
        return ResponseEntity.ok().body(new VeiculoDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<VeiculoDTO> delete(@PathVariable Long id){
        veiculoService.delete(id);
        return  ResponseEntity.noContent().build();
    }

}
