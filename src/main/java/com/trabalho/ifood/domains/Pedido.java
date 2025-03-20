package com.trabalho.ifood.domains;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.trabalho.ifood.domains.dtos.PedidoDTO;
import com.trabalho.ifood.domains.enums.StatusPedido;
import com.trabalho.ifood.domains.enums.TipoEntrega;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Pedido")
    private Long id;

    @NotNull
    @NotBlank
    private String descricaoPedido;

    @NotNull
    @NotBlank
    @Column(unique = true)
    private String tempoEspera;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPedido = LocalDate.now();

    @NotNull
    @Digits(integer = 15, fraction = 2)
    private BigDecimal valor;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "statusPedido")
    private StatusPedido statusPedido;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "tipoEntrega")
    private TipoEntrega tipoEntrega;

    @ManyToOne
    @JoinColumn(name="idPessoa")
    private Pessoa Pessoa;

    @ManyToOne
    @JoinColumn(name="idEstabelecimento")
    private Estabelecimento Estabelecimento;

    public Pedido() {
        this.valor = BigDecimal.ZERO;
        this.statusPedido= StatusPedido.PENDENTE;
        this.tipoEntrega = TipoEntrega.ENTREGA;
    }

    public Pedido(Long id, String descricaoPedido, String tempoEspera, LocalDate dataPedido, BigDecimal valor, StatusPedido status, TipoEntrega tipoEntrega, Pessoa Pessoa, Estabelecimento Estabelecimento) {
        this.id = id;
        this.descricaoPedido = descricaoPedido;
        this.tempoEspera = tempoEspera;
        this.dataPedido = dataPedido;
        this.valor = valor;
        this.statusPedido = status;
        this.tipoEntrega = tipoEntrega;
        this.Pessoa = Pessoa;
        this.Estabelecimento = Estabelecimento;
    }

    public Pedido(PedidoDTO dto) {
        this.id = dto.getId();
        this.descricaoPedido = dto.getdescricaoPedido();
        this.tempoEspera = dto.gettempoEspera();
        this.dataPedido = dto.getdataPedido();
        this.valor = dto.getvalor();

        this.Pessoa = new Pessoa();
        this.Pessoa.setIdPessoa(dto.getPessoa());
        this.Estabelecimento = new Estabelecimento();
        this.Estabelecimento.setIdEstab(dto.getEstabelecimento());
        this.statusPedido = StatusPedido.toEnum(dto.getStatus());
        this.tipoEntrega = TipoEntrega.toEnum(dto.gettipoEntrega());


    }

    public @NotNull @NotBlank String getdescricaoPedido() {
        return descricaoPedido;
    }

    public void setdescricaoPedido(@NotNull @NotBlank String descricaoPedido) {
        this.descricaoPedido = descricaoPedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull @NotBlank String gettempoEspera() {
        return tempoEspera;
    }

    public void settempoEspera(@NotNull @NotBlank String tempoEspera) {
        this.tempoEspera = tempoEspera;
    }

    public LocalDate getdataPedido() {
        return dataPedido;
    }

    public void setdataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public @NotNull @Digits(integer = 15, fraction = 2) BigDecimal getvalor() {
        return valor;
    }

    public void setvalor(@NotNull @Digits(integer = 15, fraction = 2) BigDecimal valor) {
        this.valor = valor;
    }

    public StatusPedido getStatus() {
        return statusPedido;
    }

    public void setStatus(StatusPedido status) {
        this.statusPedido = status;
    }

    public TipoEntrega gettipoEntrega() {
        return tipoEntrega;
    }

    public void settipoEntrega(TipoEntrega tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public Pessoa getPessoa() {
        return Pessoa;
    }

    public void setPessoa(Pessoa Pessoa) {
        this.Pessoa = Pessoa;
    }

    public Estabelecimento getEstabelecimento() {
        return Estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento Estabelecimento) {
        this.Estabelecimento = Estabelecimento;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido Pedido = (Pedido) o;
        return id == Pedido.id && Objects.equals(descricaoPedido, Pedido.descricaoPedido) && Objects.equals(tempoEspera, Pedido.tempoEspera) && Objects.equals(dataPedido, Pedido.dataPedido) && Objects.equals(valor, Pedido.valor) && statusPedido == Pedido.statusPedido && tipoEntrega == Pedido.tipoEntrega && Objects.equals(Pessoa, Pedido.Pessoa) && Objects.equals(Estabelecimento, Pedido.Estabelecimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricaoPedido, tempoEspera, dataPedido, valor, statusPedido, tipoEntrega, Pessoa, Estabelecimento);
    }
}
