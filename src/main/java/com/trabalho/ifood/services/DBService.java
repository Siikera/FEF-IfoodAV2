package com.trabalho.ifood.services;

import com.trabalho.ifood.domains.Cliente;
import com.trabalho.ifood.domains.Estabelecimento;
import com.trabalho.ifood.domains.Pedido;
import com.trabalho.ifood.domains.enums.StatusPedido;
import com.trabalho.ifood.domains.enums.TipoEntrega;
import com.trabalho.ifood.repositories.ClienteRepository;
import com.trabalho.ifood.repositories.EstabelecimentoRepository;
import com.trabalho.ifood.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class DBService {

    @Autowired
    private ClienteRepository ClienteRepository;

    @Autowired
    private EstabelecimentoRepository EstabelecimentoRepository;

    @Autowired
    private PedidoRepository PedidoRepository;

    public void initDB() {
        Cliente Cliente01 = new Cliente(null, "Mateus", "Rua Amildo Filho", "17992868282", "12332112365", "mateus@email.com", "mateus123");
        Estabelecimento Estabelecimento01 = new Estabelecimento(null, "11-111-1111111-11", "Vovó das Marmita", "Caseira", "5.0", new BigDecimal("2.99"));

        Cliente Cliente02 = new Cliente(null, "Cadmiel", "Rua Severino Pai", "17994786539", "98778976587", "cadmiel@email.com", "cadmiel123");
        Estabelecimento Estabelecimento02 = new Estabelecimento(null, "22-222-2222222-22", "Burguer King", "Fast-Food", "4.5", new BigDecimal("13.90"));

        Pedido Pedido01 = new Pedido(null, "Pedido1", "15 minutos", LocalDate.now(), new BigDecimal("99.90").setScale(2),
                StatusPedido.ENTREGUE, TipoEntrega.RETIRADA, Cliente01, Estabelecimento01);

        Pedido Pedido02 = new Pedido(null, "Pedido2", "40 minutos", LocalDate.now(), new BigDecimal("20.50").setScale(2),
                StatusPedido.PENDENTE, TipoEntrega.ENTREGA, Cliente02, Estabelecimento02);

        Pedido Pedido03 = new Pedido(null, "Pedido3", "10 minutos", LocalDate.now(), new BigDecimal("39.90").setScale(2),
                StatusPedido.EM_TRANSITO, TipoEntrega.RETIRADA, Cliente02, Estabelecimento01);

        Pedido Pedido04 = new Pedido(null, "Pedido4", "30 minutos", LocalDate.now(), new BigDecimal("15.00").setScale(2),
                StatusPedido.ENTREGUE, TipoEntrega.ENTREGA, Cliente01, Estabelecimento02);

        ClienteRepository.save(Cliente01);
        ClienteRepository.save(Cliente02);
        EstabelecimentoRepository.save(Estabelecimento01);
        EstabelecimentoRepository.save(Estabelecimento02);
        PedidoRepository.save(Pedido01);
        PedidoRepository.save(Pedido02);
        PedidoRepository.save(Pedido03);
        PedidoRepository.save(Pedido04);
    }
}
