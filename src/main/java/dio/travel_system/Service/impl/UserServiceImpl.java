package dio.travel_system.service.impl;

import org.springframework.stereotype.Service;


import dio.travel_system.model.User;
import dio.travel_system.repositories.UserRepository;
import dio.travel_system.service.UserService;

import java.util.List;
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
   public List<User> findAll() {
    try {
        return userRepository.findAll();
    } catch (Exception e) {
        throw new RuntimeException("error when trying to search for hosting", e);
    }
   }

    @Override
    public User create( User userToCreate){
        if (userRepository.existsBycpf(userToCreate.getCpf())) {
            throw new IllegalArgumentException("This CPF is already registered");
        }
        return userRepository.save(userToCreate);
    }

}
