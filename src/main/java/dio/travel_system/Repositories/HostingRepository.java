package dio.travel_system.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dio.travel_system.model.Hosting;

@Repository
public interface HostingRepository extends JpaRepository<Hosting, Long> {
    
    List<Hosting> findByCity(String city);
   
}