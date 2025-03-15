package dio.travel_system.service;

import java.util.List;


import dio.travel_system.model.User;

public interface UserService {
    User findbyId(Long id);

    List<User> findAll();

    User create(User userToCreate);
}
