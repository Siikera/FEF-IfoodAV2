package com.trabalho.ifood.services;

import com.trabalho.ifood.domains.Veiculo;
import com.trabalho.ifood.domains.dtos.VeiculoDTO;
import com.trabalho.ifood.repositories.VeiculoRepository;
import com.trabalho.ifood.services.exceptions.DataIntegrityViolationException;
import com.trabalho.ifood.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository VeiculoRepo;

    public List<VeiculoDTO> findAll(){
        return VeiculoRepo.findAll().stream().map(obj -> new VeiculoDTO(obj)).
                collect(Collectors.toList());

    }
    public Veiculo findbyId(Long id){
        Optional<Veiculo> obj = VeiculoRepo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Veiculo não encontrado! Id: " + id));    }

    public Veiculo findbyCpf(String cpf){
        Optional<Veiculo> obj = VeiculoRepo.findBycpf(cpf);
        return obj.orElseThrow(()-> new ObjectNotFoundException("CPF não encontrado! Id: " + cpf));    }

    public Veiculo create(VeiculoDTO dto){
        dto.setId(null);
        Veiculo obj = new Veiculo(dto);
        ValidaCPF(dto);
        return VeiculoRepo.save(obj);
    }

    public Veiculo update(Long id, VeiculoDTO objDto){
        objDto.setId(id);
        Veiculo oldObj = findbyId(id);
        oldObj = new Veiculo(objDto);
        ValidaCPF(objDto);
        return VeiculoRepo.save(oldObj);
    }

    public void delete(Long id){
        Veiculo obj = findbyId(id);
        VeiculoRepo.deleteById(id);
    }

    private void ValidaCPF(VeiculoDTO objeto){
        Optional<Veiculo> obj = VeiculoRepo.findBycpf(objeto.getCpf());
        if(!obj.isPresent() && obj.get().getId()!= objeto.getId()){
            throw new org.springframework.dao.DataIntegrityViolationException("CPF Já cadastrado no sistema.");
        }
    }


}
