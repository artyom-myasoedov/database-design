package courses.backend.service.mapper;

import courses.backend.db.entity.TimetableRecordEntity;
import courses.backend.service.model.TeacherDto;
import courses.backend.service.model.TimetableRecordDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = {ClassMapper.class, TeacherDto.class})
public interface TimetableRecordMapper {

  @Mapping(target = "classDto", source = "classEntity")
  TimetableRecordDto fromEntity(TimetableRecordEntity entity);

  @Mapping(source = "classDto", target = "classEntity")
  TimetableRecordEntity toEntity(TimetableRecordDto dto);

  List<TimetableRecordDto> fromEntities(List<TimetableRecordEntity> entities);
}
