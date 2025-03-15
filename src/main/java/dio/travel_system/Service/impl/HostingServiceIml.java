package dio.travel_system.service.impl;

import org.springframework.stereotype.Service;

import dio.travel_system.model.Hosting;
import dio.travel_system.repositories.HostingRepository;
import dio.travel_system.service.HostingService;

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
   public List<Hosting> findAll() {
    try {
        return hostingRepository.findAll();
    } catch (Exception e) {
        throw new RuntimeException("error when trying to search for hosting", e);
    }
   }

    @Override
    public Hosting create( Hosting hostingToCreate){
        return hostingRepository.save(hostingToCreate);
    }

    @Override
    public Hosting update(Hosting hostingToUpdate){
        return hostingRepository.save(hostingToUpdate);
    }
    
    @Override
    public Hosting Delete(long id) {
        Hosting hosting = findbyId(id);
        hostingRepository.delete(hosting);
        return hosting;
    }

}