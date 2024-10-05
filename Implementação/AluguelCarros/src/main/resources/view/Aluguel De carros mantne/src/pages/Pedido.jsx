import React, { useEffect, useState } from 'react';
import { Grid, Text, Button, Notification } from '@mantine/core';
import axios from 'axios';
import { useParams } from 'react-router-dom';

const Pedido = () => {
  const { id } = useParams(); // Pega o id do pedido da URL
  const [pedido, setPedido] = useState(null); // Estado para armazenar os dados do pedido
  const [veiculo, setVeiculo] = useState(null); // Estado para armazenar os dados do veículo
  const [cliente, setCliente] = useState(null); // Estado para armazenar os dados do cliente
  const [notificacao, setNotificacao] = useState(null); // Estado para armazenar notificações

  // Função para buscar os dados do pedido no banco de dados
  const fetchPedido = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/pedidos/${id}`);
      const pedidoData = response.data;
      console.log('Dados do pedido:', pedidoData);
      setPedido(pedidoData); // Atualiza o estado com os dados do pedido

      // Verifique se o veículo está definido antes de fazer a requisição
      if (pedidoData.veiculo && pedidoData.veiculo.id) {
        const veiculoResponse = await axios.get(`http://localhost:8080/veiculos/${pedidoData.veiculo.id}`);
        setVeiculo(veiculoResponse.data); // Atualiza o estado com os dados do veículo
      } else {
        console.error('Veículo não encontrado no pedido.');
      }

      // Pega o ID do cliente diretamente do localStorage
      const clienteId = localStorage.getItem('aluguelId');
      if (clienteId) {
        const clienteResponse = await axios.get(`http://localhost:8080/clientes/${clienteId}`);
        setCliente(clienteResponse.data); // Atualiza o estado com os dados do cliente
      } else {
        console.error('ID do cliente não encontrado no localStorage.');
      }
    } catch (error) {
      console.error('Erro ao buscar dados do pedido:', error);
    }
  };

  // Função para cancelar o pedido
  const cancelarPedido = async () => {
    try {
      await axios.delete(`http://localhost:8080/pedidos/${id}`); // Envia requisição para cancelar o pedido
      setNotificacao({ message: 'Pedido cancelado com sucesso!', color: 'green' });
      setPedido(null); // Limpa o pedido após o cancelamento
      window.location.href = '/'; // Redireciona para a página inicial
    } catch (error) {
      console.error('Erro ao cancelar pedido:', error);
      setNotificacao({ message: 'Erro ao cancelar pedido!', color: 'red' });
    }
  };

  const confirmarPedido = async () => {
    try {
      await axios.put(`http://localhost:8080/pedidos/${id}`, { 
        status: 'APROVADO',
        veiculoid: pedido.veiculo.id, // Use o ID do veículo atual
        clienteid: 1  // Use o ID do cliente atual
      });
      setNotificacao({ message: 'Pedido confirmado com sucesso!', color: 'green' });
      fetchPedido(); // Atualiza os dados do pedido
    } catch (error) {
      console.error('Erro ao confirmar pedido:', error);
      setNotificacao({ message: 'Erro ao confirmar pedido!', color: 'red' });
    }
  };
  
  // Função para negar o pedido
  const negarPedido = async () => {
    try {
      await axios.put(`http://localhost:8080/pedidos/${id}`, 
      { 
        status: 'NEGADO',
        veiculoid: pedido.veiculo.id,
        clienteid: 1,
      }); // Atualiza o status do pedido
      setNotificacao({ message: 'Pedido negado com sucesso!', color: 'orange' });
      fetchPedido(); // Atualiza os dados do pedido
    } catch (error) {
      console.error('Erro ao negar pedido:', error);
      setNotificacao({ message: 'Erro ao negar pedido!', color: 'red' });
    }
  };

  useEffect(() => {
    fetchPedido(); // Chama a função para buscar o pedido quando o componente é montado
  }, [id]);

  useEffect(() => {
    if (notificacao) {
      const timer = setTimeout(() => setNotificacao(null), 3000); // Limpa a notificação após 3 segundos
      return () => clearTimeout(timer); // Limpa o timer ao desmontar
    }
  }, [notificacao]);

  if (!pedido || !veiculo || !cliente) {
    return <Text>Carregando...</Text>; // Mensagem enquanto os dados estão sendo carregados
  }

  return (
    <div>
      <h1>Detalhes do Pedido</h1>
      <Grid>
        <Grid.Col span={4}>
          <Text>Marca: {veiculo.marca}</Text>
          <Text>Modelo: {veiculo.modelo}</Text>
          <Text>Placa: {veiculo.placa}</Text>
        </Grid.Col>
        <Grid.Col span={4}>
          <Text>Pedido {pedido.status}</Text>
        </Grid.Col>
        <Grid.Col span={4}>
          <Text>Cliente: {cliente.nome}</Text>
        </Grid.Col>
      </Grid>
      
      {/* Renderiza os botões apenas se o ID do cliente for 1 */}
      {cliente.id === 1 && (
        <>
          <Button color="blue" mt="md" onClick={confirmarPedido}>Confirmar Pedido</Button>
          <Button color="red" mt="md" onClick={negarPedido}>Negar Pedido</Button>
        </>
      )}
      
      <Button color="red" mt="md" onClick={cancelarPedido}>Cancelar Pedido</Button>
      {notificacao && (
        <Notification
          title="Notificação"
          color={notificacao.color}
          onClose={() => setNotificacao(null)}
          mt="md"
        >
          {notificacao.message}
        </Notification>
      )}
    </div>
  );
};

export default Pedido;
