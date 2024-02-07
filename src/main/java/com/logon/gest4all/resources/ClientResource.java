package com.logon.gest4all.resources;

import com.logon.gest4all.entities.CollectivePerson;
import com.logon.gest4all.entities.SingularPerson;
import com.logon.gest4all.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {
    @Autowired
    private ClientService service;

    @GetMapping("/singular_persons")
    public ResponseEntity<List<SingularPerson>> findAllSingularPerson() {
        List<SingularPerson> list = service.findAllSingularPerson();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/collective_persons")
    public ResponseEntity<List<CollectivePerson>> findAllCollectivePerson() {
        List<CollectivePerson> list = service.findAllCollectivePerson();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/singular_persons/{id}")
    public ResponseEntity<SingularPerson> findSingularPersonById(@PathVariable Long id) {
        SingularPerson obj = service.findSingularPersonById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/collective_persons/{id}")
    public ResponseEntity<CollectivePerson> findCollectivePersonById(@PathVariable Long id) {
        CollectivePerson obj = service.findCollectivePersonById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping("/singular_persons")
    public ResponseEntity<SingularPerson> createSingularPerson(@RequestBody SingularPerson obj) {
        obj = service.createSingularPerson(obj);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping("/collective_persons")
    public ResponseEntity<CollectivePerson> createCollectivePerson(@RequestBody CollectivePerson obj) {
        obj = service.createCollectivePerson(obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/singular_persons/{id}")
    public ResponseEntity<Void> deleteSingularPerson(@PathVariable Long id) {
        service.deleteSingularPerson(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/collective_persons/{id}")
    public ResponseEntity<Void> deleteCollectivePerson(@PathVariable Long id) {
        service.deleteCollectivePerson(id);
        return ResponseEntity.noContent().build();
    }
}
