package com.trabalho.ifood.domains;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trabalho.ifood.domains.dtos.ClienteDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_cliente")
    private Integer idCliente;

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

    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    private String senha;

    @JsonIgnore
    @OneToMany(mappedBy = "Cliente")
    private List<Pedido> pedidos = new ArrayList<>();

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Cliente() {
    }

    public Cliente(Integer idCliente, String nome, String endereco, String telefone, String cpf, String email, String senha) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }

    public Cliente(ClienteDTO dto) {
        this.idCliente = dto.getIdCliente();
        this.nome = dto.getNome();
        this.endereco = dto.getEndereco();
        this.telefone = dto.getTelefone();
        this.cpf = dto.getCpf();
        this.email = dto.getEmail();
        this.senha = dto.getSenha();
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public @NotNull @NotBlank String getSenha() {
        return senha;
    }

    public void setSenha(@NotNull @NotBlank String senha) {
        this.senha = senha;
    }

    public @NotNull @NotBlank String getEmail() {
        return email;
    }

    public void setEmail(@NotNull @NotBlank String email) {
        this.email = email;
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
        Cliente cliente = (Cliente) o;
        return Objects.equals(idCliente, cliente.idCliente) && Objects.equals(nome, cliente.nome) && Objects.equals(endereco, cliente.endereco) && Objects.equals(telefone, cliente.telefone) && Objects.equals(cpf, cliente.cpf) && Objects.equals(email, cliente.email) && Objects.equals(senha, cliente.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente, nome, endereco, telefone, cpf, email, senha);
    }
}
