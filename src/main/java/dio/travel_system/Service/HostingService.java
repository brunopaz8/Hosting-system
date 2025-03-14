package dio.travel_system.Service;

import java.util.List;

import dio.travel_system.model.Hosting;

public interface HostingService {

    Hosting findbyId(long id);

    List<Hosting> findByCity(String city);

    Hosting create(Hosting hostingToCreate);

}
