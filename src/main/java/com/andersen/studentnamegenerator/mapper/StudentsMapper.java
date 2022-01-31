package com.andersen.studentnamegenerator.mapper;
import com.andersen.studentnamegenerator.dto.StudentsRequestDto;
import com.andersen.studentnamegenerator.dto.StudentsResponseDto;
import com.andersen.studentnamegenerator.entity.Students;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StudentsMapper {
    StudentsResponseDto toDto(Students entity);
    Students toEntity(StudentsRequestDto dto);
    void update(Students source, @MappingTarget Students target);
}
