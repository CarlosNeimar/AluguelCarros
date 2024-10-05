const handleLogin = async () => {
  const loginData = {
      login: 'seu_login',
      senha: 'sua_senha',
  };

  const response = await fetch('http://localhost:8080/clientes/login', {
      method: 'POST',
      headers: {
          'Content-Type': 'application/json',
      },
      body: JSON.stringify(loginData),
  });

  const data = await response.json();
  if (response.ok) {
      console.log('Login successful', data);
  } else {
      console.error('Login failed');
  }
};
