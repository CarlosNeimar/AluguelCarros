import React, { useState, useEffect } from 'react';
import Pedidocard from '../components/PedidoCard';
import { Grid } from '@mantine/core';
import axios from 'axios';

const ListaPedidos = () => {
  const [clienteid, setclienteid] = useState('');
  const [pedidos, setPedidos] = useState([]);

  const handlePedidos = async () => {
    try {
      if (clienteid) {
        const response = await axios.get(`http://localhost:8080/clientes/${clienteid}`);
        setPedidos(response.data.pedidos); // Acessa a lista de pedidos diretamente
      }
    } catch (error) {
      console.error("Erro ao buscar pedidos:", error);
    }
  };

  useEffect(() => {
    const idclientelocal = localStorage.getItem('aluguelId');
    if (idclientelocal) {
      setclienteid(idclientelocal); 
    }
  }, []);

  useEffect(() => {
    if (clienteid) {
      handlePedidos();
    }
  }, [clienteid]);

  return (
    <div>
      <h1>Lista de pedidos do cliente</h1>
      <Grid>
        {pedidos.map((pedido, index) => (
          <Grid.Col span={4} key={index}>
            <Pedidocard
              marca={pedido.veiculo.marca} 
              modelo={pedido.veiculo.modelo}
              placa={pedido.veiculo.placa}
              status={pedido.status} 
              id={pedido.id}
            />
          </Grid.Col>
        ))}
      </Grid>
    </div>
  );
}

export default ListaPedidos;
