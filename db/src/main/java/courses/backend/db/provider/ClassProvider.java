package courses.backend.db.provider;

import courses.backend.db.entity.ClassEntity;
import courses.backend.db.entity.EducationDirection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ClassProvider {

  Optional<ClassEntity> findById(Integer classId);

  void deleteById(Integer classId);

  Page<ClassEntity> findAll(Pageable pageable);

  ClassEntity save(ClassEntity entity);

  Page<ClassEntity> findByLevel(Integer level, Pageable pageable);

  Page<ClassEntity> findByLevelAfter(Integer level, Pageable pageable);

  Page<ClassEntity> findByLevelBefore(Integer level, Pageable pageable);

  Page<ClassEntity> findByProgram_Direction(EducationDirection direction, Pageable pageable);

  Page<ClassEntity> findByName(String name, Pageable pageable);
}
