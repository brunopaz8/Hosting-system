package dio.travel_system.Service;

import dio.travel_system.model.User;

public interface UserService {
    User findbyId(Long id);

    User create(User userToCreate);
}
