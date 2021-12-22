package courses.backend.service.logic;

import courses.backend.service.model.ComparisonOperation;
import courses.backend.service.model.PageDto;
import courses.backend.service.model.ProgramDto;
import org.springframework.data.domain.Page;

public interface ProgramService {

  ProgramDto findById(Integer id);

  void deleteById(Integer id);

  PageDto<ProgramDto> findAll(Integer pageNumber, Integer pageSize);

  ProgramDto save(ProgramDto dto);

  PageDto<ProgramDto> findByLevel(Integer level, ComparisonOperation operation, Integer pageNumber, Integer pageSize);

  PageDto<ProgramDto> findByDirection(String direction, Integer pageNumber, Integer pageSize);

}
