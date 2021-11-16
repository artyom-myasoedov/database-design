package courses.backend.service.mapper;

import courses.backend.db.entity.TimetableRecordEntity;
import courses.backend.service.model.TeacherDto;
import courses.backend.service.model.TimetableRecordDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = {ClassMapper.class, TeacherDto.class})
public interface TimetableRecordMapper {

  TimetableRecordDto fromEntity(TimetableRecordEntity entity);

  TimetableRecordEntity toEntity(TimetableRecordDto dto);

  List<TimetableRecordDto> fromEntities(List<TimetableRecordEntity> entities);
}
