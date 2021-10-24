package courses.backend.db.provider.impl;

import courses.backend.db.entity.ClassEntity;
import courses.backend.db.entity.EducationDirection;
import courses.backend.db.provider.ClassProvider;
import courses.backend.db.repository.ClassRepository;
import courses.backend.db.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClassProviderImpl implements ClassProvider {

  private final ClassRepository repository;

  @Autowired
  public ClassProviderImpl(ClassRepository repository) {
    this.repository = repository;
  }

  @Override
  public Optional<ClassEntity> findById(Integer classId) {
    return repository.findById(classId);
  }

  @Override
  public void deleteById(Integer classId) {
    repository.deleteById(classId);
  }

  @Override
  public Page<ClassEntity> findAll(Pageable pageable) {
    return repository.findAll(pageable);
  }

  @Override
  public ClassEntity save(ClassEntity entity) {
    return repository.save(entity);
  }

  @Override
  public Page<ClassEntity> findByLevel(Integer level, Pageable pageable) {
    return repository.findByLevel(level, pageable);
  }

  @Override
  public Page<ClassEntity> findByLevelAfter(Integer level, Pageable pageable) {
    return repository.findByLevelAfter(level, pageable);
  }

  @Override
  public Page<ClassEntity> findByLevelBefore(Integer level, Pageable pageable) {
    return repository.findByLevelBefore(level, pageable);
  }

  @Override
  public Page<ClassEntity> findByProgram_Direction(EducationDirection direction, Pageable pageable) {
    return repository.findByProgram_Direction(direction, pageable);
  }

  @Override
  public Page<ClassEntity> findByName(String name, Pageable pageable) {
    return repository.findByName(name, pageable);
  }
}
