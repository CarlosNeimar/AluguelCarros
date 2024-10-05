import { Card, Image, Text, Badge, Button, Group } from '@mantine/core';
import { useNavigate } from 'react-router-dom';

function Pedidocard({marca, modelo, placa, status, id}) {
  const navigate = useNavigate();

  const handleAlugar = () => {
    navigate(`/pedido/${id}`);
  };

  return (
    <Card shadow="sm" padding="lg" radius="md" withBorder>

      <Group justify="space-between" mt="md" mb="xs">
        <Text fw={500}>{marca} {modelo} {placa}</Text>
        <Badge color="pink">{status}</Badge>
      </Group>

      <Button color="blue" fullWidth mt="md" radius="md" onClick={handleAlugar}>
        Ver detalhes
      </Button>
    </Card>
  );
}

export default Pedidocard;