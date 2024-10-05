import { Card, Text, Badge, Button, Group } from '@mantine/core';
import { useNavigate } from 'react-router-dom';
import { useDisclosure } from '@mantine/hooks';
import ConfirmarPedido from './ConfirmarPedido';

function CardVeiculo({ marca, modelo, id, placa }) {
  const navigate = useNavigate();
  
  // Controle de estado para abrir e fechar o modal
  const [opened, { open, close }] = useDisclosure(false);

  return (
    <Card shadow="sm" padding="lg" radius="md" withBorder>
      <Group justify="space-between" mt="md" mb="xs">
        <Text fw={500}>
          {marca} {modelo}
        </Text>
        <Badge color="pink">Disponível</Badge>
      </Group>

      {/* Botão que abre o modal */}
      <Button color="blue" fullWidth mt="md" radius="md" onClick={open}>
        Alugar carro
      </Button>

      {/* Componente ConfirmarPedido que recebe as props */}
      <ConfirmarPedido 
        opened={opened} 
        close={close} 
        marca={marca}
        modelo={modelo}
        id={id}
        placa={placa}
      />
    </Card>
  );
}

export default CardVeiculo;
