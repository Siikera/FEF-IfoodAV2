package com.trabalho.ifood.domains;

import com.trabalho.ifood.domains.dtos.VeiculoDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "Veiculo")
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_Veiculo")
    private Long id;

    @NotNull
    @NotBlank
    private  String descricao;

    @NotNull
    private LocalDate dataAquisicao;

    @NotNull
    private Double valorAquisicao;

    @NotNull
    @NotBlank
    private String nomeProprietario;

    @NotNull
    @NotBlank
    private String cpf;

    public Veiculo() {
    }

    public Veiculo(Long id, String descricao, LocalDate dataAquisicao, String nomeProprietario, Double valorAquisicao, String cpf) {
        this.id = id;
        this.descricao = descricao;
        this.dataAquisicao = dataAquisicao;
        this.nomeProprietario = nomeProprietario;
        this.valorAquisicao = valorAquisicao;
        this.cpf = cpf;
    }

    public Veiculo(VeiculoDTO dto) {
        this.id = dto.getId();
        this.descricao = dto.getDescricao();
        this.dataAquisicao = dto.getDataAquisicao();
        this.valorAquisicao = dto.getValorAquisicao();
        this.nomeProprietario = dto.getNomeProprietario();
        this.cpf = dto.getCpf();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public Double getValorAquisicao() {
        return valorAquisicao;
    }

    public void setValorAquisicao(Double valorAquisicao) {
        this.valorAquisicao = valorAquisicao;
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(id, veiculo.id) && Objects.equals(descricao, veiculo.descricao) && Objects.equals(dataAquisicao, veiculo.dataAquisicao) && Objects.equals(valorAquisicao, veiculo.valorAquisicao) && Objects.equals(nomeProprietario, veiculo.nomeProprietario) && Objects.equals(cpf, veiculo.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, dataAquisicao, valorAquisicao, nomeProprietario, cpf);
    }
}
