package dio.travel_system.Service.impl;

import org.springframework.stereotype.Service;

import dio.travel_system.Service.HostingService;
import dio.travel_system.Repositories.HostingRepository;
import dio.travel_system.model.Hosting;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class HostingServiceIml implements HostingService{

    private final HostingRepository hostingRepository;

    public HostingServiceIml(HostingRepository hostingRepository){
        this.hostingRepository = hostingRepository;
    }

   @Override
   public Hosting findbyId(long id){
    return hostingRepository.findById(id).orElseThrow(NoSuchElementException :: new);
   }

   @Override
   public List<Hosting> findByCity(String city) {
    return hostingRepository.findByCity(city);
   }

    @Override
    public Hosting create( Hosting hostingToCreate){
        return hostingRepository.save(hostingToCreate);
    }

}