package dio.travel_system.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dio.travel_system.handler.ResourceNotFoundException;
import dio.travel_system.model.Hosting;
import dio.travel_system.service.HostingService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/hosting")
public class HostingController {

    private HostingService hostingService;

    public HostingController(HostingService hostingService){
        this.hostingService = hostingService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hosting> findById(@PathVariable long id) {
        Hosting hosting = hostingService.findbyId(id);
        if (hosting == null) {
             throw new ResourceNotFoundException("User with ID " + id + " not found.");
        }
        return ResponseEntity.ok(hosting);
    }

    @GetMapping("/{city}")
    public ResponseEntity<List<Hosting>> getByCity(@PathVariable String city) {
        List<Hosting> hosting = hostingService.findbyCity(city);
        if (hosting.isEmpty()){
            throw new ResourceNotFoundException("No hosting found in " + city);
        }
        return ResponseEntity.ok(hosting);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Hosting> create(@Valid @RequestBody Hosting hostingToCreate) {
        var hostingCreated = hostingService.create(hostingToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(hostingCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(hostingCreated);
    }

    
}
