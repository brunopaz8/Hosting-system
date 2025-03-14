package dio.travel_system.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import dio.travel_system.Service.HostingService;
import dio.travel_system.model.Hosting;


@RestController
@RequestMapping("/hosting")
public class HostingController {

    private HostingService hostingService;

    public HostingController(HostingService hostingService){
        this.hostingService = hostingService;
    }

    @GetMapping
    public ResponseEntity<Hosting> findById(@PathVariable long id) {
        return ResponseEntity.ok(hostingService.findbyId(id));
    }

    @PostMapping
    public ResponseEntity<Hosting> create(@RequestBody Hosting hostingToCreate) {
        var hostingCreated = hostingService.create(hostingToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(hostingCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(hostingCreated);
    }
}
