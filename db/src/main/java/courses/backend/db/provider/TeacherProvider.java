package courses.backend.db.provider;

import courses.backend.db.entity.Subject;
import courses.backend.db.entity.TeacherEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TeacherProvider {


  Optional<TeacherEntity> findById(Integer classId);

  void deleteById(Integer classId);

  Page<TeacherEntity> findAll(Pageable pageable);

  TeacherEntity save(TeacherEntity entity);

  Page<TeacherEntity> findByFirstNameLikeAndLastNameLike(String firstName, String lastName, Pageable pageable);

  Page<TeacherEntity> findBySubjects(List<Subject> subjects, Pageable pageable);
}
