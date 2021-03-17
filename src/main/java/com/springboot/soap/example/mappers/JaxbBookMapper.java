package com.springboot.soap.example.mappers;

import com.springboot.soap.example.jaxb.generated.pojos.Book;
import com.springboot.soap.example.model.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JaxbBookMapper {
    JaxbBookMapper INSTANCE = Mappers.getMapper(JaxbBookMapper.class);
    BookDto jaxBToDto(Book book);
}
