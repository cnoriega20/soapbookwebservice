package com.springboot.soap.example.endpoints;

import com.springboot.soap.example.jaxb.generated.pojos.GetBookRequest;
import com.springboot.soap.example.jaxb.generated.pojos.GetBookResponse;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

public interface BookServiceEndpoint {
    public GetBookResponse getCountry(@RequestPayload GetBookRequest request);
}
