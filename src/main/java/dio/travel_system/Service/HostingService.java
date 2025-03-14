package dio.travel_system.Service;

import dio.travel_system.model.Hosting;

public interface HostingService {

    Hosting findbyId(long id);

    Hosting create(Hosting hostingToCreate);


}
