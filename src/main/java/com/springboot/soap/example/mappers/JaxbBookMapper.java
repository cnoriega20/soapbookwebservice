package com.springboot.soap.example.mappers;

import com.springboot.soap.example.domain.BookEntity;
import com.springboot.soap.example.jaxb.generated.pojos.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JaxbBookMapper {
    JaxbBookMapper INSTANCE = Mappers.getMapper(JaxbBookMapper.class);
    BookEntity jaxBToEntity(Book book);
    Book entityToJaxb(BookEntity bookEntity);
}
