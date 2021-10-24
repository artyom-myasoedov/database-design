package courses.backend.db.provider;

import courses.backend.db.entity.EducationDirection;
import courses.backend.db.entity.ProgramEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProgramProvider {

  Optional<ProgramEntity> findById(Integer programId);

  void deleteById(Integer programId);

  Page<ProgramEntity> findAll(Pageable pageable);

  ProgramEntity save(ProgramEntity entity);

  Page<ProgramEntity> findByLevel(Integer level, Pageable pageable);

  Page<ProgramEntity> findByLevelBefore(Integer level, Pageable pageable);

  Page<ProgramEntity> findByLevelAfter(Integer level, Pageable pageable);

  Page<ProgramEntity> findByDirection(EducationDirection direction, Pageable pageable);
}
