import React, { useState, useEffect } from 'react';
import Card from '../components/Card';
import { Grid } from '@mantine/core';
import axios from 'axios';

const Home = () => {
  const [veiculos, setVeiculos] = useState([]);
  const [nome, setNome] = useState('');

  const handleCars = async () => {
    try {
      const response = await axios.get('http://localhost:8080/veiculos');
      setVeiculos(response.data); // Atualiza o estado com os veículos recebidos
    } catch (error) {
      console.error("Erro ao buscar veículos:", error);
    }
  };

  useEffect(() => {
    handleCars(); // Chama a função para buscar os veículos quando o componente é montado
    const nomeLocal = localStorage.getItem('aluguelNome');
    setNome(nomeLocal); // Define o nome vindo do localStorage no estado
  }, []);

  return (
    <div>
      <h1>Olá {nome}, Alugue seu carro aqui</h1>   
      <Grid>
        {veiculos.map((veiculo, index) => (
          <Grid.Col span={4} key={index}>
            <Card
            marca={veiculo.marca} 
            modelo={veiculo.modelo} 
            id={veiculo.id}
            placa={veiculo.placa}
            />
          </Grid.Col>
        ))}
      </Grid>
    </div>
  );
}

export default Home;
