package courses.backend.db.repository;

import courses.backend.db.entity.PupilEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PupilRepository extends JpaRepository<PupilEntity, Integer> {

  Page<PupilEntity> findByFirstNameLikeAndLastNameLike(String firstName, String lastName, Pageable pageable);

  Page<PupilEntity> findByClassEntity_Id(Integer classId, Pageable pageable);

  Page<PupilEntity> findByClassEntity_Level(Integer level, Pageable pageable);


}
