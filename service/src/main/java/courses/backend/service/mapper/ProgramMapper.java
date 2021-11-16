package courses.backend.service.mapper;

import courses.backend.db.entity.ProgramEntity;
import courses.backend.service.model.ProgramDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProgramMapper {

  ProgramDto fromEntity(ProgramEntity entity);

  ProgramEntity toEntity(ProgramDto dto);

  List<ProgramDto> fromEntities(List<ProgramEntity> entities);
}
