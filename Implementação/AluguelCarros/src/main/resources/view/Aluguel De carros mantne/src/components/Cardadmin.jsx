import { Card, Badge, Button, Group, Notification, Grid, Text } from '@mantine/core';
import { useNavigate, useParams } from 'react-router-dom';
import { useState, useEffect } from 'react';
import axios from 'axios';

function CardAdmin({ marca, modelo, placa, status, idcar, id }) {

  const [pedido, setPedido] = useState(null); // Estado para armazenar os dados do pedido
  const [notificacao, setNotificacao] = useState(null); // Estado para armazenar notificações


  const confirmarPedido = async () => {
    try {
      await axios.put(`http://localhost:8080/pedidos/${id}`, {
        status: 'APROVADO',
        veiculoid: idcar, // Use o ID do veículo atual
        clienteid: 1, // Use um ID de cliente padrão ou necessário
      });
      setNotificacao({ message: 'Pedido confirmado com sucesso!', color: 'green' });
      setTimeout(() => {
        window.location.reload(); // Recarrega a página após um pequeno delay
      }, 1000); // Delay de 1 segundo para que a notificação possa ser lida
    } catch (error) {
      console.error('Erro ao confirmar pedido:', error);
      setNotificacao({ message: 'Erro ao confirmar pedido!', color: 'red' });
    }
  };

  const negarPedido = async () => {
    try {
      await axios.put(`http://localhost:8080/pedidos/${id}`, 
      { 
        status: 'NEGADO',
        veiculoid: idcar,
        clienteid: 1,
      }); // Atualiza o status do pedido
      setNotificacao({ message: 'Pedido negado com sucesso!', color: 'orange' });
      setTimeout(() => {
        window.location.reload(); // Recarrega a página após um pequeno delay
      }, 1000); // Delay de 1 segundo para que a notificação possa ser lida
    } catch (error) {
      console.error('Erro ao negar pedido:', error);
      setNotificacao({ message: 'Erro ao negar pedido!', color: 'red' });
    }
  };

  const handleAlugar = () => {
    navigate(`/pedido/${id}`);
  };

  // Exibir notificação por 3 segundos
  useEffect(() => {
    if (notificacao) {
      const timer = setTimeout(() => setNotificacao(null), 3000); // Limpa a notificação após 3 segundos
      return () => clearTimeout(timer); // Limpa o timer ao desmontar
    }
  }, [notificacao]);

  return (
    <Card shadow="sm" padding="lg" radius="md" withBorder>
      <Group justify="space-between" mt="md" mb="xs">
        <Text fw={500}>{marca} {modelo} {placa}</Text>
        <Badge color="pink">{status}</Badge>
      </Group>
      <Grid>
        <Grid.Col span={6}>
          <Button color="green" mt="md" radius="md" onClick={confirmarPedido}>
            Aprovar Pedido
          </Button>
        </Grid.Col>
        <Grid.Col span={6}>
          <Button color="red" mt="md" radius="md" onClick={negarPedido}>
            Negar Pedido
          </Button>
        </Grid.Col>
      </Grid>

      {/* Notificação */}
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
    </Card>
  );
}

export default CardAdmin;
