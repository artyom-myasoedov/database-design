package courses.backend.service.mapper;

import courses.backend.db.entity.ClassEntity;
import courses.backend.service.model.ClassDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = {ProgramMapper.class, TeacherMapper.class})
public interface ClassMapper {

  ClassDto fromEntity(ClassEntity entity);

  ClassEntity toEntity(ClassDto dto);

  List<ClassDto> fromEntities(List<ClassEntity> entities);
}
