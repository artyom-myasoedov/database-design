package courses.backend.db.provider;

import courses.backend.db.entity.PupilEntity;
import courses.backend.db.entity.PupilEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;


public interface PupilProvider {

  Optional<PupilEntity> findById(Integer id);

  void deleteById(Integer id);

  Page<PupilEntity> findAll(Pageable pageable);

  PupilEntity save(PupilEntity entity);

  Page<PupilEntity> findByFirstNameLikeAndLastNameLike(String firstName, String lastName, Pageable pageable);

  Page<PupilEntity> findByPupilEntity_ClassId(Integer classId, Pageable pageable);

  Page<PupilEntity> findByPupilEntity_Level(Integer level, Pageable pageable);

    boolean isUsernameUnique(String username);
}
