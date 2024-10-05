import axios from 'axios';
import React, { useState, useEffect } from 'react';
import { Input, Title, Button, PasswordInput } from '@mantine/core';
import { useNavigate } from 'react-router-dom'; // Se estiver usando react-router
import previewImage from '../assets/previewpng.png'; // Ajuste o caminho conforme necessário

const Login = () => {
  const [login, setLogin] = useState('');
  const [senha, setSenha] = useState('');
  const navigate = useNavigate(); // Hook para navegação

  // Função para lidar com o login
  const handleLogin = async () => {
    try {
      const response = await axios.post('http://localhost:8080/clientes/login', {
        login: login,
        senha: senha,
      });

      // Supondo que a API retorna um objeto com nome e id
      const { nome, id } = response.data;

      // Salvar nome e id no localStorage
      localStorage.setItem('aluguelNome', nome);
      localStorage.setItem('aluguelId', id);

      alert('Login realizado com sucesso!');
      navigate('/'); // Redireciona para a página inicial
    } catch (error) {
      console.error('Erro ao fazer login', error);
      alert('Falha no login. Verifique seu usuário e senha.');
    }
  };

  // Verificar se o usuário está logado
  useEffect(() => {
    const nome = localStorage.getItem('aluguelNome');
    const id = localStorage.getItem('aluguelId');

    if (nome && id) {
      alert('Usuário já está logado!');
      navigate('/'); // Se estiver logado, redireciona para a página inicial
    }
  }, [navigate]);

  return (
    <div style={{ display: 'flex', height: '100vh' }}>
      {/* Formulário de Login */}
      <div style={{ display: 'flex', flexDirection: 'column', justifyContent: 'center', marginLeft: '50px' }}>
        <Title order={1}>Login</Title>
        <div style={{ marginBottom: '10px' }}>
          <Input.Wrapper label="Login" style={{ marginBottom: '10px' }}>
            <Input
              size="md"
              radius="md"
              value={login}
              onChange={(e) => setLogin(e.target.value)}
              placeholder="Digite seu login"
              style={{ marginLeft: '10px' }} // Alinhamento levemente à direita
            />
          </Input.Wrapper>

          <Input.Wrapper label="Senha">
            <PasswordInput
              size="md"
              radius="md"
              value={senha}
              onChange={(e) => setSenha(e.target.value)}
              placeholder="Digite sua senha"
              style={{ marginLeft: '10px' }} // Alinhamento levemente à direita
            />
          </Input.Wrapper>
        </div>
        <Button onClick={handleLogin} variant="filled" size="md" radius="md" style={{ marginLeft: '10px' }}>
          Entrar
        </Button>
      </div>

      {/* Imagem ao lado do formulário */}
      <div style={{ flexGrow: 1, display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
        <img src={previewImage} alt="Preview" style={{ maxHeight: '50%', maxWidth: '50%' }} />
      </div>
    </div>
  );
};

export default Login;
