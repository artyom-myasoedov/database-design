package courses.backend.db.provider.impl;

import courses.backend.db.entity.Subject;
import courses.backend.db.entity.TeacherEntity;
import courses.backend.db.provider.TeacherProvider;
import courses.backend.db.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TeacherProviderImpl implements TeacherProvider {

  private final TeacherRepository repository;

  @Autowired
  public TeacherProviderImpl(TeacherRepository repository) {
    this.repository = repository;
  }

  @Override
  public Optional<TeacherEntity> findById(Integer teacherId) {
    return repository.findById(teacherId);
  }

  @Override
  public void deleteById(Integer teacherId) {
    repository.deleteById(teacherId);
  }

  @Override
  public Page<TeacherEntity> findAll(Pageable pageable) {
    return repository.findAll(pageable);
  }

  @Override
  public TeacherEntity save(TeacherEntity entity) {
    return repository.save(entity);
  }

  @Override
  public Page<TeacherEntity> findByFirstNameLikeAndLastNameLike(String firstName, String lastName, Pageable pageable) {
    return repository.findByFirstNameLikeAndLastNameLike(firstName, lastName, pageable);
  }

  @Override
  public Page<TeacherEntity> findBySubjects(List<Subject> subjects, Pageable pageable) {
    return repository.findBySubjects(subjects, pageable);
  }
}
