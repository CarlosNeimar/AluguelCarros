package com.lab02.AluguelCarros;

import java.util.Arrays;

import com.lab02.AluguelCarros.models.Cliente;
import com.lab02.AluguelCarros.models.Pedido;
import com.lab02.AluguelCarros.models.Veiculo;
import com.lab02.AluguelCarros.models.enums.PedidoStatus;
import com.lab02.AluguelCarros.repositories.ClienteRepository;
import com.lab02.AluguelCarros.repositories.PedidoRepository;
import com.lab02.AluguelCarros.repositories.VeiculoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AluguelCarrosApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private VeiculoRepository veiculoRepository;

	public static void main(String[] args) {
		SpringApplication.run(AluguelCarrosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Cliente cliente1 = new Cliente(1, "Admin", "admin", "supersenha");
		Cliente cliente2 = new Cliente(null, "Neimar", "neimar", "supersenha");
		Cliente cliente3 = new Cliente(null, "Nery", "nery", "supersenha");

		Pedido pedido1 = new Pedido(null, PedidoStatus.APROVADO);
		Pedido pedido2 = new Pedido(null, PedidoStatus.NEGADO);
		cliente2.getPedidos().addAll(Arrays.asList(pedido1, pedido2));
		pedido1.setCliente(cliente2);
		pedido2.setCliente(cliente2);

		Veiculo veiculo1 = new Veiculo(null, "Aramuni", "BMW", "X1");
		Veiculo veiculo2 = new Veiculo(null, "AAA3031", "Ford", "Fiesta");
		veiculo1.getPedidos().addAll(Arrays.asList(pedido1));
		veiculo2.getPedidos().addAll(Arrays.asList(pedido2));
		pedido1.setVeiculo(veiculo1);
		pedido2.setVeiculo(veiculo2);

		clienteRepository.saveAll(Arrays.asList(cliente1, cliente2, cliente3));
		veiculoRepository.saveAll(Arrays.asList(veiculo1, veiculo2));
		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2));
	}

}