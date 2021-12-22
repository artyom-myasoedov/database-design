package courses.backend.service.logic;


import courses.backend.db.entity.ClassEntity;
import courses.backend.service.model.ClassDto;
import courses.backend.service.model.ComparisonOperation;
import courses.backend.service.model.PageDto;

public interface ClassService {

  ClassDto findById(Integer classId);

  void deleteById(Integer classId);

  PageDto<ClassDto> findAll(Integer pageNumber, Integer pageSize);

  ClassDto save(ClassDto dto);

  PageDto<ClassDto> findByLevel(Integer level, ComparisonOperation operation, Integer pageNumber, Integer pageSize);

  PageDto<ClassDto> findByProgram_Direction(String direction, Integer pageNumber, Integer pageSize);

  PageDto<ClassDto> findByName(String name, Integer pageNumber, Integer pageSize);

  PageDto<ClassEntity> findAllEntities(int i, int i1);
}
