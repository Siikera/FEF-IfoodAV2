package com.trabalho.ifood.domains.dtos;

import com.trabalho.ifood.domains.Veiculo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Objects;

public class VeiculoDTO {

    private Long id;

    @NotNull(message = "O campo descricao não pode ser nulo")
    @NotBlank(message = "O campo descricao não pode estar vazio ")
    private String descricao;

    @NotNull(message = "O campo dataAquisicao não pode ser Nulo")
    private LocalDate dataAquisicao;

    @NotNull(message = "O campo valorAquisicao não pode ser Nulo")
    private Double valorAquisicao;

    @NotNull(message = "O campo nomeProprietario não pode ser Nulo")
    @NotBlank (message = "O campo nomeProprietario não pode estar vazio")
    private String nomeProprietario;

    @NotNull(message = "O campo cpf não pode ser Nulo")
    @NotBlank (message = "O campo cpf não pode estar vazio")
    private String cpf;

    public VeiculoDTO() {
    }


    public VeiculoDTO(Veiculo veiculo) {
        this.id = veiculo.getId();
        this.descricao = veiculo.getDescricao();
        this.dataAquisicao = veiculo.getDataAquisicao();
        this.valorAquisicao = veiculo.getValorAquisicao();
        this.nomeProprietario = veiculo.getNomeProprietario();
        this.cpf = veiculo.getCpf();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "O campo descricao não pode ser nulo") @NotBlank(message = "O campo descricao não pode estar vazio ") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull(message = "O campo descricao não pode ser nulo") @NotBlank(message = "O campo descricao não pode estar vazio ") String descricao) {
        this.descricao = descricao;
    }

    public @NotNull(message = "O campo dataAquisicao não pode ser Nulo") LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(@NotNull(message = "O campo dataAquisicao não pode ser Nulo") LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public @NotNull(message = "O campo valorAquisicao não pode ser Nulo") Double getValorAquisicao() {
        return valorAquisicao;
    }

    public void setValorAquisicao(@NotNull(message = "O campo valorAquisicao não pode ser Nulo") Double valorAquisicao) {
        this.valorAquisicao = valorAquisicao;
    }

    public @NotNull(message = "O campo nomeProprietario não pode ser Nulo") @NotBlank(message = "O campo nomeProprietario não pode estar vazio") String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(@NotNull(message = "O campo nomeProprietario não pode ser Nulo") @NotBlank(message = "O campo nomeProprietario não pode estar vazio") String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public @NotNull(message = "O campo cpf não pode ser Nulo") @NotBlank(message = "O campo cpf não pode estar vazio") String getCpf() {
        return cpf;
    }

    public void setCpf(@NotNull(message = "O campo cpf não pode ser Nulo") @NotBlank(message = "O campo cpf não pode estar vazio") String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VeiculoDTO that = (VeiculoDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(descricao, that.descricao) && Objects.equals(dataAquisicao, that.dataAquisicao) && Objects.equals(valorAquisicao, that.valorAquisicao) && Objects.equals(nomeProprietario, that.nomeProprietario) && Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, dataAquisicao, valorAquisicao, nomeProprietario, cpf);
    }
}
