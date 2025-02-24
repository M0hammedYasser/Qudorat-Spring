package com.spring.qudorat.model.mapper;

import com.spring.qudorat.model.dto.ClientResponse;
import com.spring.qudorat.model.entity.Client;
import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientMapper {

    public ClientResponse map(Client client) {
        return ClientResponse.builder()
                .id(client.getId())
                .name(client.getName())
                .phone(client.getPhone())
                .email(client.getEmail())
                .address(client.getAddress())
                .build();
    }

    public List<ClientResponse> map(List<Client> clients) {
        List<ClientResponse> responses = new ArrayList<>();
        for (Client client : clients)
            responses.add(map(client));
        return responses;
    }
}
