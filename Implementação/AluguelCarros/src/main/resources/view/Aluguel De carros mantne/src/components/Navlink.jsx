import { useState } from 'react';
import { useLocation } from 'react-router-dom'; // Importa useLocation
import { SlSpeedometer } from "react-icons/sl";
import { BsClipboard2Heart } from "react-icons/bs";
import { FaRegUser } from "react-icons/fa";
import { Box, NavLink } from '@mantine/core';

const data = [
  {
    icon: SlSpeedometer,
    label: 'Veiculos',
    description: 'Alugue seu veiculo'
  },
  {
    icon: BsClipboard2Heart,
    label: 'Pedidos',
    description: 'Veja seus pedidos',
  },
  {
    icon: FaRegUser,
    label: 'Admin',
    description: 'Area do Administrador',
    id: 1 // Adicionando o ID que pode ver o item
  },
];

function MyNavLink() {
  const location = useLocation(); // Obtém a localização atual
  const [active, setActive] = useState(0);
  const userId = localStorage.getItem('aluguelId'); // Supondo que o ID do usuário esteja no localStorage

  const items = data.map((item, index) => {
    // Condicional para mostrar o item "Admin" apenas se o ID do usuário for 1
    if (item.label === 'Admin' && userId !== '1') {
      return null; // Não renderiza o item
    }

    // Verifica se o caminho atual corresponde ao nome do item
    const isActive = location.pathname === `/${item.label.toLowerCase()}`;

    return (
      <NavLink
        href="#required-for-focus"
        key={item.label}
        active={isActive} // Define se o item está ativo
        label={item.label}
        description={item.description}
        rightSection={item.rightSection}
        leftSection={<item.icon size="1rem" stroke={1.5} />}
        onClick={() => window.location.href = `/${item.label.toLowerCase()}`}
      />
    );
  });

  return <Box w={220}>{items}</Box>;
}

export default MyNavLink;
  