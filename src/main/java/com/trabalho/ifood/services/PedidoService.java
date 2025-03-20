package com.trabalho.ifood.services;


import com.trabalho.ifood.domains.Pessoa;
import com.trabalho.ifood.domains.Estabelecimento;
import com.trabalho.ifood.domains.Pedido;
import com.trabalho.ifood.domains.dtos.PedidoDTO;
import com.trabalho.ifood.repositories.PessoaRepository;
import com.trabalho.ifood.repositories.EstabelecimentoRepository;
import com.trabalho.ifood.repositories.PedidoRepository;
import com.trabalho.ifood.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository PedidoRepo;

    @Autowired
    private PessoaRepository PessoaRepo;

    @Autowired
    private EstabelecimentoRepository EstabelecimentoRepo;

    public List<PedidoDTO> findAll() {
        return PedidoRepo.findAll().stream().map(obj -> new PedidoDTO(obj)).
                collect(Collectors.toList());
    }

    public Pedido findbyId(Long id) {
        Optional<Pedido> obj = PedidoRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Pedido não encontrado! Id: " + id));
    }

    public Pedido create(PedidoDTO dto) {
        dto.setId(null);
        validaPedido(dto);
        Pedido obj = new Pedido(dto);
        return PedidoRepo.save(obj);
    }

    private void validaPedido(PedidoDTO dto) {
        Optional<Pessoa> Pessoa = PessoaRepo.findById(dto.getPessoa());
        if(!Pessoa.isPresent()){
            throw new DataIntegrityViolationException("Pessoa - " + dto.getPessoa() + " não está cadastrado.");
        }

        Optional<Estabelecimento> Estabelecimento = EstabelecimentoRepo.findById(dto.getEstabelecimento());
        if(!Estabelecimento.isPresent()){
            throw new DataIntegrityViolationException("Estabelecimento - " + dto.getEstabelecimento() + " não está cadastrada.");
        }
    }
    public Pedido update(Long id, PedidoDTO objDto){
        objDto.setId(id);
        Pedido oldObj = findbyId(id);
        validaPedido(objDto);
        oldObj = new Pedido(objDto);
        return PedidoRepo.save(oldObj);
    }

    public void delete(Long id){
        Pedido obj = findbyId(id);
        PedidoRepo.deleteById(id);
    }




}
