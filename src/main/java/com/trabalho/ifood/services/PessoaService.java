package com.trabalho.ifood.services;

import com.trabalho.ifood.domains.Pessoa;
import com.trabalho.ifood.domains.dtos.PessoaDTO;
import com.trabalho.ifood.repositories.PessoaRepository;
import com.trabalho.ifood.services.exceptions.DataIntegrityViolationException;
import com.trabalho.ifood.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository PessoaRepo;

    public List<PessoaDTO> findAll(){
        //retorna uma lista de PessoaDTO
        return PessoaRepo.findAll().stream().map(obj -> new PessoaDTO(obj)).
                collect(Collectors.toList());

    }
    public Pessoa findbyId(int id){
        Optional<Pessoa> obj = PessoaRepo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Pessoa não encontrado! Id: " + id));    }

    public Pessoa create(PessoaDTO dto){
        dto.setIdPessoa(null);
        Pessoa obj = new Pessoa(dto);
        return PessoaRepo.save(obj);
    }

    public Pessoa update(Integer id, PessoaDTO objDto){
        objDto.setIdPessoa(id);
        Pessoa oldObj = findbyId(id);
        oldObj = new Pessoa(objDto);
        return PessoaRepo.save(oldObj);
    }

    public void delete(Integer id){
        Pessoa obj = findbyId(id);
        if (obj.getPedidos().size()>0){
            throw new DataIntegrityViolationException("Pessoa não pode ser deletado, pois tem um pedido vinculado ");
        }
        PessoaRepo.deleteById(id);
    }

}

