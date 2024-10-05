import { AppShell, Burger } from '@mantine/core';
import { useDisclosure } from '@mantine/hooks';
import { Outlet, useNavigate } from 'react-router-dom';
import { useEffect } from 'react';
import MyNavLink from './Navlink';
import previewImage from '../assets/previewpng.png'; // Ajuste o caminho conforme necessário

function Navbar() {
  const [opened, { toggle }] = useDisclosure();
  const navigate = useNavigate();

  // Verificar se o usuário está logado
  useEffect(() => {
    const nome = localStorage.getItem('aluguelNome');
    const id = localStorage.getItem('aluguelId');

    // Se não houver nome ou id, redirecionar para a página de login
    if (!nome || !id) {
      alert('Você precisa estar logado para acessar esta página.');
      navigate('/login'); // Redireciona para a página de login
    }
  }, [navigate]);

  return (
    <AppShell
      header={{ height: 60 }}
      navbar={{
        width: 300,
        breakpoint: 'sm',
        collapsed: { mobile: !opened },
      }}
      padding="md"
    >
      <AppShell.Header>
        <Burger
          opened={opened}
          onClick={toggle}
          hiddenFrom="sm"
          size="sm"
        />
        <div>
          <img src={previewImage} alt="Preview" 
          style={{
             height: '55px',
             marginLeft: '20px',
             }} />
        </div>
      </AppShell.Header>

      <AppShell.Navbar p="md">
        <MyNavLink />
      </AppShell.Navbar>

      <AppShell.Main>
        <Outlet />
      </AppShell.Main>
    </AppShell>
  );
}

export default Navbar;
