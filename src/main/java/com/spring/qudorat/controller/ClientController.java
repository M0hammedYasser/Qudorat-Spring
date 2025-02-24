package com.spring.qudorat.controller;

import com.spring.qudorat.model.dto.ClientResponse;
import com.spring.qudorat.model.entity.Client;
import com.spring.qudorat.service.ClientService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;

    @GetMapping
    public List<ClientResponse> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ClientResponse findById(@PathVariable int id){
        return service.findById(id);
    }

    @GetMapping("/count")
    public Long count(){
        return service.count();
    }

    @PostMapping
    public Client insert(@RequestBody Client client){
        return service.save(client);
    }

    @PutMapping("/{id}")
    public Client update(@RequestBody Client client , @PathVariable int id){
        client.setId(id);
        return service.save(client);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        service.deleteById(id);
    }

}
