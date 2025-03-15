package dio.travel_system.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    @GetMapping
    public ResponseEntity<List<Hosting>> findAll() {
        List<Hosting> hostingList = hostingService.findAll();
        return ResponseEntity.ok(hostingList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hosting> findById(@PathVariable long id) {
        Hosting hosting = hostingService.findbyId(id);
        return ResponseEntity.ok(hosting);
    }
    
    @PostMapping
    public ResponseEntity<Hosting> create(@Valid @RequestBody Hosting hostingToCreate) {
        var hostingCreated = hostingService.create(hostingToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(hostingCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(hostingCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hosting> update(@PathVariable long id, @Valid @RequestBody Hosting hostingToUpdate) {
        hostingToUpdate.setId(id);
        var hostingUpdated = hostingService.update(hostingToUpdate);
        return ResponseEntity.ok(hostingUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Hosting> delete(@PathVariable long id) {
        var hostingDeleted = hostingService.Delete(id);
        return ResponseEntity.ok(hostingDeleted);
    }

    
}
