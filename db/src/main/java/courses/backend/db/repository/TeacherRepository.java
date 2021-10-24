package courses.backend.db.repository;

import courses.backend.db.entity.Subject;
import courses.backend.db.entity.TeacherEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEntity, Integer> {

  Page<TeacherEntity> findByFirstNameLikeAndLastNameLike(String firstName, String lastName, Pageable pageable);

  @Query("select t from teachers t where ?1 in (t.subjects)")
  Page<TeacherEntity> findBySubjects(List<Subject> subjects, Pageable pageable);


}
