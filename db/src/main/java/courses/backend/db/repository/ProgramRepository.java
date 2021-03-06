package courses.backend.db.repository;

import courses.backend.db.entity.EducationDirection;
import courses.backend.db.entity.ProgramEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProgramRepository extends JpaRepository<ProgramEntity, Integer> {

  Page<ProgramEntity> findByLevel(Integer level, Pageable pageable);

  Page<ProgramEntity> findByLevelBefore(Integer level, Pageable pageable);

  Page<ProgramEntity> findByLevelAfter(Integer level, Pageable pageable);

  Page<ProgramEntity> findByDirection(EducationDirection direction, Pageable pageable);
}
