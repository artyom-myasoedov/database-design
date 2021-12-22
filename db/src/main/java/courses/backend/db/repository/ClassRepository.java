package courses.backend.db.repository;

import courses.backend.db.entity.ClassEntity;
import courses.backend.db.entity.EducationDirection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClassRepository extends JpaRepository<ClassEntity, Integer> {

  Page<ClassEntity> findByLevel(Integer level, Pageable pageable);

  Page<ClassEntity> findByLevelAfter(Integer level, Pageable pageable);

  Page<ClassEntity> findByLevelBefore(Integer level, Pageable pageable);

  Page<ClassEntity> findByProgram_Direction(EducationDirection direction, Pageable pageable);

  Page<ClassEntity> findByName(String name, Pageable pageable);

}
