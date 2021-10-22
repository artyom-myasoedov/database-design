package courses.backend.db.repository;

import courses.backend.db.entity.PupilEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PupilRepository extends JpaRepository<PupilEntity, Integer> {

  Collection<PupilEntity> findByFirstNameLikeAndLastNameLike(String firstName, String lastName);


}
