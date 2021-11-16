package courses.backend.service.mapper;

import courses.backend.db.entity.PupilEntity;
import courses.backend.service.model.PupilDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface PupilMapper {

  @Mapping(target = "password", ignore = true)
  PupilDto fromEntity(PupilEntity entity);

  PupilEntity toEntity(PupilDto dto);

  List<PupilDto> fromEntities(List<PupilEntity> entities);
}
