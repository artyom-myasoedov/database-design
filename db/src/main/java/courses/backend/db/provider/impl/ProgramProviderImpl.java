package courses.backend.db.provider.impl;

import courses.backend.db.entity.EducationDirection;
import courses.backend.db.entity.ProgramEntity;
import courses.backend.db.provider.ProgramProvider;
import courses.backend.db.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProgramProviderImpl implements ProgramProvider {

  private final ProgramRepository repository;

  @Autowired
  public ProgramProviderImpl(ProgramRepository repository) {
    this.repository = repository;
  }

  @Override
  public Optional<ProgramEntity> findById(Integer programId) {
    return repository.findById(programId);
  }

  @Override
  public void deleteById(Integer programId) {
    repository.deleteById(programId);
  }

  @Override
  public Page<ProgramEntity> findAll(Pageable pageable) {
    return repository.findAll(pageable);
  }

  @Override
  public ProgramEntity save(ProgramEntity entity) {
    return repository.save(entity);
  }

  @Override
  public Page<ProgramEntity> findByLevel(Integer level, Pageable pageable) {
    return repository.findByLevel(level, pageable);
  }

  @Override
  public Page<ProgramEntity> findByLevelBefore(Integer level, Pageable pageable) {
    return repository.findByLevelBefore(level, pageable);
  }

  @Override
  public Page<ProgramEntity> findByLevelAfter(Integer level, Pageable pageable) {
    return repository.findByLevelAfter(level, pageable);
  }

  @Override
  public Page<ProgramEntity> findByDirection(EducationDirection direction, Pageable pageable) {
    return repository.findByDirection(direction, pageable);
  }
}
