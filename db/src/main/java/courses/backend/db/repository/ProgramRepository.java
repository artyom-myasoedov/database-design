package courses.backend.db.repository;

import courses.backend.db.entity.EducationDirection;
import courses.backend.db.entity.ProgramEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ProgramRepository extends JpaRepository<ProgramEntity, Integer> {

  Collection<ProgramEntity> findByLevel(Integer level);

  Collection<ProgramEntity> findByLevelBefore(Integer level);

  Collection<ProgramEntity> findByLevelAfter(Integer level);

  Collection<ProgramEntity> findByDirection(EducationDirection direction);
}
