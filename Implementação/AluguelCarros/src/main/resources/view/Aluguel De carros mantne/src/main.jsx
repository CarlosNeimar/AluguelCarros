import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import App from './App.jsx'
import './index.css'
import '@mantine/core/styles.css';
import { MantineProvider } from '@mantine/core';
import Pedido from './pages/Pedido.jsx'
import ListaPedidos from './pages/ListaPedidos.jsx';

import { createBrowserRouter, RouterProvider } from 'react-router-dom'

import Home from './pages/Home.jsx'
import Login from './pages/Login.jsx'
import Admin from './pages/Admin.jsx';

const router = createBrowserRouter([
  {
    path: '/login',
    element: <Login />,
  },
  {
    path: '/',
    element: <App />,
    children: [
      {
        path: '/veiculos',
        element: <Home />,
      },
      {
        path: '/',
        element: <Home />,
      },
      {
        path: "/pedido/:id",
        element: <Pedido />,
      },
      {
        path: '/pedidos',
        element: <ListaPedidos />,
      },
      {
        path: '/admin',
        element: <Admin />,
      }
    ]
  },
])

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <MantineProvider>
      <RouterProvider router={router} />
    </MantineProvider>
  </StrictMode>,
)
