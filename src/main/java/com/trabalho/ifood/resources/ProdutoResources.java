package com.trabalho.ifood.resources;

import com.trabalho.ifood.domains.Produto;
import com.trabalho.ifood.domains.dtos.ProdutoDTO;
import com.trabalho.ifood.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoResources {

        @Autowired
        private ProdutoService produtoService;

        @GetMapping
        public ResponseEntity<List<ProdutoDTO>> findAll(){
                return ResponseEntity.ok().body(produtoService.findAll());
        }

        @GetMapping(value = "/{id}")
        public ResponseEntity<ProdutoDTO> findbyId(@PathVariable Long id){
                Produto obj = this.produtoService.findbyId(id);
                return ResponseEntity.ok().body(new ProdutoDTO(obj));
        }

        @GetMapping(value = "/codigobarra/{codigoBarra}")
        public ResponseEntity<ProdutoDTO> findById(@PathVariable String codigoBarra){
                Produto obj = this.produtoService.findbycodigoBarra(codigoBarra);
                return ResponseEntity.ok().body(new ProdutoDTO(obj));
        }
}