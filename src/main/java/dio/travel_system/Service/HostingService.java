package dio.travel_system.service;

import java.util.List;

import dio.travel_system.model.Hosting;

public interface HostingService {

    Hosting findbyId(long id);

    List<Hosting> findAll();

    Hosting create(Hosting hostingToCreate);

    Hosting update(Hosting hostingToUpdate);

    Hosting Delete(long id);

}
