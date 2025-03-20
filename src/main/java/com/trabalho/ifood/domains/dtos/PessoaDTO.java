package com.trabalho.ifood.domains.dtos;


import com.trabalho.ifood.domains.Pessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PessoaDTO {

    private Integer idPessoa;

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

    public PessoaDTO() {
    }

    public PessoaDTO(Pessoa pessoa) {
        this.idPessoa = pessoa.getIdPessoa();
        this.nome = pessoa.getNome();
        this.endereco = pessoa.getEndereco();
        this.telefone = pessoa.getTelefone();
        this.cpf = pessoa.getCpf();
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
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

    public @NotNull(message = "O campo cpf não pode ser Nulo") @NotBlank(message = "O campo cpf não pode estar vazio") String getCpf() {
        return cpf;
    }

    public void setCpf(@NotNull(message = "O campo cpf não pode ser Nulo") @NotBlank(message = "O campo cpf não pode estar vazio") String cpf) {
        this.cpf = cpf;
    }
}
