package dio.travel_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dio.travel_system.model.Hosting;

@Repository
public interface HostingRepository extends JpaRepository<Hosting, Long> {
    
   
}