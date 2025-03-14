package dio.travel_system.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dio.travel_system.model.User;

@Repository
public interface UserRepositories extends JpaRepository<User, Long> {
    
}
