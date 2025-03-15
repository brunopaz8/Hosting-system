package dio.travel_system.service;

import java.util.List;

import dio.travel_system.model.Hosting;

public interface HostingService {

    Hosting findbyId(long id);

    List<Hosting> findbyCity(String city);

    Hosting create(Hosting hostingToCreate);

}
