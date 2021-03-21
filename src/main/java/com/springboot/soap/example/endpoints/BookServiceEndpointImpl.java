package com.springboot.soap.example.endpoints;

import com.springboot.soap.example.jaxb.generated.pojos.GetBookRequest;
import com.springboot.soap.example.jaxb.generated.pojos.GetBookResponse;
import com.springboot.soap.example.mappers.BookMapper;
import com.springboot.soap.example.mappers.JaxbBookMapper;
import com.springboot.soap.example.repositories.BookRepository;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BookServiceEndpointImpl implements BookServiceEndpoint {
    private static final String NAMESPACE_URI = "https://www.java2blog.com/xml/book";

    private final BookRepository bookRepository;

    private final JaxbBookMapper jaxbBookMapper;

    public BookServiceEndpointImpl(BookRepository bookRepository, JaxbBookMapper jaxbBookMapper, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.jaxbBookMapper = jaxbBookMapper;

    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBookRequest")
    @ResponsePayload
    public GetBookResponse getCountry(@RequestPayload GetBookRequest request){

        GetBookResponse response = new GetBookResponse();
        if(request !=null){
            response.setBook(jaxbBookMapper.entityToJaxb(bookRepository.findById(request.getId()).get()));
        }
        return response;
    }

}
