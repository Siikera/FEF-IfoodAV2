package com.trabalho.ifood.services;

import com.trabalho.ifood.domains.*;
import com.trabalho.ifood.domains.enums.StatusPedido;
import com.trabalho.ifood.domains.enums.TipoEntrega;
import com.trabalho.ifood.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class DBService {

    @Autowired
    private EstabelecimentoRepository EstabelecimentoRepository;

    @Autowired
    private PedidoRepository PedidoRepository;

    @Autowired
    private ClienteRepository ClienteRepository;

    @Autowired
    private EntregadorRepository EntregadorRepository;


    public void initDB() {
        Entregador Entregador01 = new Entregador(null, "Cadmiel", "Rua Severino Pai", "17994786539", "98778976587");
        Cliente Cliente01 = new Cliente(null, "Mateus", "Rua Amildo Filho", "17992868282", "12332112365");
        Entregador Entregador02 = new Entregador(null, "Vitin", "Rua Fernando Alonso", "1792347632", "23467890955");
        Cliente Cliente02 = new Cliente(null, "Pedro", "Rua Luis Hamilton", "17998653987", "12356789764");
        
        Estabelecimento Estabelecimento01 = new Estabelecimento(null, "11-111-1111111-11", "Vovó das Marmita", "Caseira", "5.0", new BigDecimal("2.99"));

        Estabelecimento Estabelecimento02 = new Estabelecimento(null, "22-222-2222222-22", "Burguer King", "Fast-Food", "4.5", new BigDecimal("13.90"));

        Pedido Pedido01 = new Pedido(null, "Pedido1", "15 minutos", new BigDecimal("99.90").setScale(2),
                StatusPedido.ENTREGUE,TipoEntrega.RETIRADA, Cliente01, Entregador01 , Estabelecimento01);

        Pedido Pedido02 = new Pedido(null, "Pedido1", "15 minutos", new BigDecimal("99.90").setScale(2),
                StatusPedido.ENTREGUE,TipoEntrega.RETIRADA, Cliente02, Entregador02 , Estabelecimento02);

        Pedido Pedido03 = new Pedido(null, "Pedido1", "15 minutos", new BigDecimal("99.90").setScale(2),
                StatusPedido.ENTREGUE,TipoEntrega.RETIRADA, Cliente01, Entregador02 , Estabelecimento01);

        ClienteRepository.save(Cliente01);
        ClienteRepository.save(Cliente02);
        EntregadorRepository.save(Entregador01);
        EntregadorRepository.save(Entregador02);
        EstabelecimentoRepository.save(Estabelecimento01);
        EstabelecimentoRepository.save(Estabelecimento02);
        PedidoRepository.save(Pedido01);
        PedidoRepository.save(Pedido02);
        PedidoRepository.save(Pedido03);
    }
}
