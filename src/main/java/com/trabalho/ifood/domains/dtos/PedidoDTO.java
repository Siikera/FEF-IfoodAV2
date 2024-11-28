package com.trabalho.ifood.domains.dtos;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.trabalho.ifood.domains.Pedido;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PedidoDTO {

    private Long id;

    @NotNull(message = "O campo descricaoPedido não pode ser nulo")
    @NotBlank (message = "O campo descricaoPedido não pode estar vazio")
    private String descricaoPedido;

    @NotNull(message = "O campo tempoEspera não pode ser nulo")
    @NotBlank (message = "O campo tempoEspera não pode estar vazio")
    private String tempoEspera;
    

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPedido = LocalDate.now();

    @NotNull (message = "O campo Valor de Compra não pode ser nulo")
    @Digits(integer = 15, fraction = 2)
    private BigDecimal valor;

    private int statusPedido;
    private int tipoEntrega;

    @NotNull(message = "O campo Cliente é requerido")
    private int Cliente;

    @NotNull(message = "O campo Estabelecimento é requerido")
    private int Estabelecimento;

    public PedidoDTO() {
    }

    public PedidoDTO(Pedido Pedido) {
        this.id = Pedido.getId();
        this.descricaoPedido = Pedido.getdescricaoPedido();
        this.tempoEspera = Pedido.gettempoEspera();
        this.dataPedido = Pedido.getdataPedido();
        this.valor = Pedido.getvalor();
        this.statusPedido = Pedido.getStatus().getId();
        this.tipoEntrega = Pedido.gettipoEntrega().getId();
        Cliente = Pedido.getCliente().getIdCliente();
        Estabelecimento = Pedido.getEstabelecimento().getIdEstab();
    }

    @NotNull(message = "O campo Estabelecimento é requerido")
    public int getEstabelecimento() {
        return Estabelecimento;
    }

    public void setEstabelecimento(@NotNull(message = "O campo Estabelecimento é requerido") int Estabelecimento) {
        Estabelecimento = Estabelecimento;
    }

    @NotNull(message = "O campo Cliente é requerido")
    public int getCliente() {
        return Cliente;
    }

    public void setCliente(@NotNull(message = "O campo Cliente é requerido") int Cliente) {
        Cliente = Cliente;
    }

    public int gettipoEntrega() {
        return tipoEntrega;
    }

    public void settipoEntrega(int tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public int getStatus() {
        return statusPedido;
    }

    public void setStatus(int status) {
        this.statusPedido = status;
    }

    public @NotNull(message = "O campo Valor de Compra não pode ser nulo") @Digits(integer = 15, fraction = 2) BigDecimal getvalor() {
        return valor;
    }

    public void setvalor(@NotNull(message = "O campo Valor de Compra não pode ser nulo") @Digits(integer = 15, fraction = 2) BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getdataPedido() {
        return dataPedido;
    }

    public void setdataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }


    public @NotNull(message = "O campo tempoEspera não pode ser nulo") @NotBlank(message = "O campo tempoEspera não pode estar vazio") String gettempoEspera() {
        return tempoEspera;
    }

    public void settempoEspera(@NotNull(message = "O campo tempoEspera não pode ser nulo") @NotBlank(message = "O campo tempoEspera não pode estar vazio") String tempoEspera) {
        this.tempoEspera = tempoEspera;
    }

    public @NotNull(message = "O campo descricaoPedido não pode ser nulo") @NotBlank(message = "O campo descricaoPedido não pode estar vazio") String getdescricaoPedido() {
        return descricaoPedido;
    }

    public void setdescricaoPedido(@NotNull(message = "O campo descricaoPedido não pode ser nulo") @NotBlank(message = "O campo descricaoPedido não pode estar vazio") String descricaoPedido) {
        this.descricaoPedido = descricaoPedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

