package courses.backend.service.mapper;

import courses.backend.db.entity.TeacherEntity;
import courses.backend.service.model.TeacherDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface TeacherMapper {


  @Mapping(target = "password", ignore = true)
  TeacherDto fromEntity(TeacherEntity entity);

  TeacherEntity toEntity(TeacherDto dto);

  List<TeacherDto> fromEntities(List<TeacherEntity> entities);
}
