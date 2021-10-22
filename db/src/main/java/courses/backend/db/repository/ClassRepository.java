package courses.backend.db.repository;

import courses.backend.db.entity.ClassEntity;
import courses.backend.db.entity.EducationDirection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity, Integer> {

  Collection<ClassEntity> findByLevel(Integer level);

  Collection<ClassEntity> findByLevelAfter(Integer level);

  Collection<ClassEntity> findByLevelBefore(Integer level);

  Collection<ClassEntity> findByProgram_Direction(EducationDirection direction);

  Collection<ClassEntity> findByName(String name);
}
