package dio.travel_system.service.impl;

import org.springframework.stereotype.Service;

import dio.travel_system.controller.handler.InvalidException;
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
    return hostingRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Host With Id " + id + " Not Found"));
   }

   @Override
   public List<Hosting> findAll() {
       List<Hosting> hostings = hostingRepository.findAll();
       if (hostings.isEmpty()) {
           throw new NoSuchElementException("No Hosts Found");
       }
       return hostings;
   }

   @Override
   public Hosting create(Hosting hostingToCreate) {
       if (hostingToCreate.getUser() == null) {
           throw new InvalidException("O usuário da hospedagem não pode ser nulo.");
       }
       if (hostingToCreate.getStreet() == null || hostingToCreate.getStreet().trim().isEmpty()) {
           throw new InvalidException("O campo 'street' é obrigatório.");
       }
       if (hostingToCreate.getCity() == null || hostingToCreate.getCity().trim().isEmpty()) {
           throw new InvalidException("O campo 'city' é obrigatório.");
       }
       if (hostingToCreate.getState() == null || hostingToCreate.getState().trim().isEmpty()) {
           throw new InvalidException("O campo 'state' é obrigatório.");
       }
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