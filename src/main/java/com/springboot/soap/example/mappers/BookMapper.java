package com.springboot.soap.example.mappers;

import com.springboot.soap.example.domain.BookEntity;
import com.springboot.soap.example.model.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
    BookDto mapToDto(BookEntity bookEntity);
    BookEntity mapToEntity(BookDto bookDto);
}
