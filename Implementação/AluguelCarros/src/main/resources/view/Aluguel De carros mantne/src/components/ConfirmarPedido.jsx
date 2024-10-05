import { Modal, Card, Image, Text, Button } from '@mantine/core';
import { useState, useEffect } from 'react';

function ConfirmarPedido({ opened, close, marca, modelo, id, placa }) {
  const [clienteid, setClienteId] = useState('');

  useEffect(() => {
    const idClienteLocal = localStorage.getItem('aluguelId');
    setClienteId(idClienteLocal); // Pegando o clienteid do localStorage
  }, []);

  // Função para fazer a requisição para o backend
  const handleConfirmarPedido = async () => {
    try {
      const response = await fetch('http://localhost:8080/pedidos', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          veiculoid: id, // Enviando apenas o ID do veículo
          clienteid: clienteid, // Enviar apenas o ID do cliente
          status: 'PENDENTE',
        }),
      });

      if (response.ok) {
        const data = response.headers.get('content-length') > 0 ? await response.json() : null;
        console.log('Pedido confirmado com sucesso:', data);
        close(); // Fechar o modal
      } else {
        console.error('Erro ao confirmar o pedido');
      }
    } catch (error) {
      console.error('Erro na requisição:', error);
    }
  };

  return (
    <Modal opened={opened} onClose={close} title="Confirme seu pedido">
      <Card shadow="sm" padding="xl" component="a" target="_blank">
        <Card.Section>
          <Image
            src="https://img.freepik.com/fotos-gratis/casal-elegante-e-elegante-em-um-salao-de-carro_1157-24861.jpg"
            height={160}
          />
        </Card.Section>

        <Text fw={500} size="lg" mt="md">
          Confirme seu pedido aqui
        </Text>

        <Text mt="xs" c="dimmed" size="sm">
          <p>Marca: {marca}</p>
          <p>Modelo: {modelo}</p>
          <p>Placa: {placa}</p>
          <p>ID: {id}</p>
        </Text>

        <Button fullWidth onClick={handleConfirmarPedido}>
          Confirmar pedido
        </Button>
      </Card>
    </Modal>
  );
}

export default ConfirmarPedido;
