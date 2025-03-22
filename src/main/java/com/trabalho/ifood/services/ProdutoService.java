package com.trabalho.ifood.services;


import com.trabalho.ifood.domains.Produto;
import com.trabalho.ifood.domains.dtos.ProdutoDTO;
import com.trabalho.ifood.repositories.ProdutoRepository;
import com.trabalho.ifood.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepo;

    public List<ProdutoDTO> findAll(){
        //retorna uma lista de GrupoProdutoDRO
        return produtoRepo.findAll().stream()
                .map(obj -> new ProdutoDTO(obj))
                .collect(Collectors.toList());
    }

    public Produto findbyId(Long id){
        Optional<Produto> obj = produtoRepo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Produto não encontrado! Id: " + id));
    }

    public Produto findbycodigoBarra(String codigoBarra){
        Optional<Produto> obj = produtoRepo.findByCodigoBarra(codigoBarra);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Codigo de barras não encontrado! Codigo de barras: " + codigoBarra));
    }

}