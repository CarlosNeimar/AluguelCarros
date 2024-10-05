import React, { useState, useEffect } from 'react';
import CardAdmin from '../components/Cardadmin';
import { Grid } from '@mantine/core';
import axios from 'axios';

const Admin = () => {

  const [pedidos, setPedidos] = useState([]);

  const handlePedidos = async () => {
    try {
      const response = await axios.get('http://localhost:8080/pedidos');
      setPedidos(response.data);
    } catch (error) {
      console.error("Erro ao buscar pedidos:", error);
    }
  };

  useEffect(() => {
    handlePedidos();
  }, []);

  return (
    <div>
      <Grid>
        {pedidos.map((pedido, index) => (
          <Grid.Col span={4} key={index}>
            <CardAdmin
              marca={pedido.veiculo.marca} 
              modelo={pedido.veiculo.modelo}
              placa={pedido.veiculo.placa}
              status={pedido.status} 
              idcar={pedido.veiculo.id}
              id={pedido.id}
            />
          </Grid.Col>
        ))}
      </Grid>
    </div>
  )
}

export default Admin
