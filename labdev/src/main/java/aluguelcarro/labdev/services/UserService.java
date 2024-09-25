package aluguelcarro.labdev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import aluguelcarro.labdev.models.User;
import aluguelcarro.labdev.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    // Método para criar um novo usuário
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Método para encontrar um usuário por ID
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    // Método para listar todos os usuários
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    // Método para atualizar um usuário
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id " + id));
        
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        return userRepository.save(user);
    }

    // Método para deletar um usuário
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
