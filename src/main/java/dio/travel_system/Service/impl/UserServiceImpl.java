package dio.travel_system.Service.impl;

import org.springframework.stereotype.Service;

import dio.travel_system.Repositories.UserRepository;
import dio.travel_system.Service.UserService;
import dio.travel_system.model.User;
import java.util.NoSuchElementException;




@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findbyId(Long id){
        return userRepository.findById(id).orElseThrow(NoSuchElementException :: new);
    }

    @Override
    public User create( User userToCreate){
        if (userRepository.existsByUsercpf(userToCreate.getUser().getCpf())) {
            throw new IllegalArgumentException("This cpf is already in use");
        }
        return userRepository.save(userToCreate);
    }

}
