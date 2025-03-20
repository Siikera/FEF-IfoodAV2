package com.trabalho.ifood.domains;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trabalho.ifood.domains.dtos.PessoaDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_pessoa")
    private Integer idPessoa;

    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    @NotBlank
    private String endereco;

    @NotNull
    @NotBlank
    private String telefone;

    @NotNull
    @NotBlank
    private String cpf;

    @JsonIgnore
    @OneToMany(mappedBy = "Pessoa")
    private List<Pedido> pedidos = new ArrayList<>();

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Pessoa() {
    }

    public Pessoa(Integer idPessoa, String nome, String endereco, String telefone, String cpf) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public Pessoa(PessoaDTO dto) {
        this.idPessoa = dto.getIdPessoa();
        this.nome = dto.getNome();
        this.endereco = dto.getEndereco();
        this.telefone = dto.getTelefone();
        this.cpf = dto.getCpf();
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public @NotNull @NotBlank String getCpf() {
        return cpf;
    }

    public void setCpf(@NotNull @NotBlank String cpf) {
        this.cpf = cpf;
    }

    public @NotNull @NotBlank String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotNull @NotBlank String telefone) {
        this.telefone = telefone;
    }

    public @NotNull @NotBlank String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotNull @NotBlank String endereco) {
        this.endereco = endereco;
    }

    public @NotNull @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotNull @NotBlank String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(idPessoa, pessoa.idPessoa) && Objects.equals(nome, pessoa.nome) && Objects.equals(endereco, pessoa.endereco) && Objects.equals(telefone, pessoa.telefone) && Objects.equals(cpf, pessoa.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPessoa, nome, endereco, telefone, cpf);
    }
}
