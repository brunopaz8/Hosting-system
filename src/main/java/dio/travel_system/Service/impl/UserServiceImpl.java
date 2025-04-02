package dio.travel_system.service.impl;

import org.springframework.stereotype.Service;

import dio.travel_system.controller.handler.InvalidException;
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
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User With Id " + id + " Not Found"));

    }

    @Override
   public List<User> findAll() {
    List<User> users = userRepository.findAll();
    if(users.isEmpty()){
        throw new NoSuchElementException("No Users Found");
    }
    return users;
   }

    @Override
    public User create( User userToCreate){
        
        if (userToCreate.getName() == null || userToCreate.getName().trim().isEmpty()) {
            throw new InvalidException("The 'Name' Field Is Required");
        }
        if(userToCreate.getCpf() == null || userToCreate.getCpf().trim().isEmpty()){
            throw new InvalidException("The 'CPF' Field Is Required");
        }
        if (userRepository.existsBycpf(userToCreate.getCpf())) {
            throw new InvalidException("This CPF is already registered");
        }
        if (userToCreate.getStreet() == null || userToCreate.getStreet().trim().isEmpty()) {
            throw new InvalidException("The 'STREET' Field Is Required");
        }
        if (userToCreate.getNumber() == null || userToCreate.getNumber().trim().isEmpty()) {
            throw new InvalidException("The 'NUMBER' Field Is Required");
        }
        if (userToCreate.getCity() == null || userToCreate.getCity().trim().isEmpty()) 
        {
            throw new InvalidException("The 'CITY' Field Is Required");
        }
        return userRepository.save(userToCreate);
    }

    @Override
    public User update(User userToUpdate){
        return userRepository.save(userToUpdate);
    }

    @Override
    public User Delete(Long id) {
        User user = findbyId(id);
        if( user == null){
            throw new NoSuchElementException("User With Id " + id + " Not Found");
        }
        userRepository.delete(user);
        return user;
    }

}
