package courses.backend.db.repository;

import courses.backend.db.entity.Subject;
import courses.backend.db.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, Integer> {

  Collection<TeacherEntity> findByFirstNameLikeAndLastNameLike(String firstName, String lastName);

  @Query("select t from teachers t where ?1 in (t.subjects)")
  Collection<TeacherEntity> findBySubjects(List<Subject> subjects);


}
