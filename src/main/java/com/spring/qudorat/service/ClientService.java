package com.spring.qudorat.service;

import com.spring.qudorat.exception.exceptions.RecordNotFountException;
import com.spring.qudorat.model.dto.ClientResponse;
import com.spring.qudorat.model.entity.Client;
import com.spring.qudorat.model.mapper.ClientMapper;
import com.spring.qudorat.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;
    private final ClientMapper mapper;

    public List<ClientResponse> findAll() {
        return mapper.map(repository.findAll());
    }

    public long count() {
        return repository.count();
    }

    public ClientResponse findById(int id) {
        return mapper.map(repository.findById(id).orElseThrow(() -> new RecordNotFountException("Client Not found")));
    }

    public Client save(Client client) {
        return repository.save(client);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

}
