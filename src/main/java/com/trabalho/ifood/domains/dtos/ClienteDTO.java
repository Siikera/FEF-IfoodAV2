package com.trabalho.ifood.domains.dtos;


import com.trabalho.ifood.domains.Cliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ClienteDTO {

    private Integer idCliente;

    @NotNull(message = "O campo Nome não pode ser nulo")
    @NotBlank(message = "O campo Nome não pode estar vazio ")
    private String nome;

    @NotNull(message = "O campo endereco não pode ser Nulo")
    @NotBlank (message = "O campo endereco não pode estar vazio")
    private String endereco;

    @NotNull(message = "O campo telefone não pode ser Nulo")
    @NotBlank (message = "O campo telefone não pode estar vazio")
    private String telefone;

    @NotNull(message = "O campo cpf não pode ser Nulo")
    @NotBlank (message = "O campo cpf não pode estar vazio")
    private String cpf;

    @NotNull(message = "O campo email não pode ser Nulo")
    @NotBlank (message = "O campo email não pode estar vazio")
    private String email;

    @NotNull(message = "O campo senha não pode ser Nulo")
    @NotBlank (message = "O campo senha não pode estar vazio")
    private String senha;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.nome = cliente.getNome();
        this.endereco = cliente.getEndereco();
        this.telefone = cliente.getTelefone();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.senha = cliente.getSenha();
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public @NotNull(message = "O campo Nome não pode ser nulo") @NotBlank(message = "O campo Nome não pode estar vazio ") String getNome() {
        return nome;
    }

    public void setNome(@NotNull(message = "O campo Nome não pode ser nulo") @NotBlank(message = "O campo Nome não pode estar vazio ") String nome) {
        this.nome = nome;
    }

    public @NotNull(message = "O campo endereco não pode ser Nulo") @NotBlank(message = "O campo endereco não pode estar vazio") String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotNull(message = "O campo endereco não pode ser Nulo") @NotBlank(message = "O campo endereco não pode estar vazio") String endereco) {
        this.endereco = endereco;
    }

    public @NotNull(message = "O campo telefone não pode ser Nulo") @NotBlank(message = "O campo telefone não pode estar vazio") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotNull(message = "O campo telefone não pode ser Nulo") @NotBlank(message = "O campo telefone não pode estar vazio") String telefone) {
        this.telefone = telefone;
    }

    public @NotNull(message = "O campo email não pode ser Nulo") @NotBlank(message = "O campo email não pode estar vazio") String getEmail() {
        return email;
    }

    public void setEmail(@NotNull(message = "O campo email não pode ser Nulo") @NotBlank(message = "O campo email não pode estar vazio") String email) {
        this.email = email;
    }

    public @NotNull(message = "O campo cpf não pode ser Nulo") @NotBlank(message = "O campo cpf não pode estar vazio") String getCpf() {
        return cpf;
    }

    public void setCpf(@NotNull(message = "O campo cpf não pode ser Nulo") @NotBlank(message = "O campo cpf não pode estar vazio") String cpf) {
        this.cpf = cpf;
    }

    public @NotNull(message = "O campo senha não pode ser Nulo") @NotBlank(message = "O campo senha não pode estar vazio") String getSenha() {
        return senha;
    }

    public void setSenha(@NotNull(message = "O campo senha não pode ser Nulo") @NotBlank(message = "O campo senha não pode estar vazio") String senha) {
        this.senha = senha;
    }
}
