package courses.backend.db.provider.impl;

import courses.backend.db.entity.PupilEntity;
import courses.backend.db.entity.PupilEntity;
import courses.backend.db.provider.PupilProvider;
import courses.backend.db.repository.PupilRepository;
import courses.backend.db.repository.PupilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PupilProviderImpl implements PupilProvider {


  private final PupilRepository repository;

  @Autowired
  public PupilProviderImpl(PupilRepository repository) {
    this.repository = repository;
  }

  @Override
  public Optional<PupilEntity> findById(Integer pupilId) {
    return repository.findById(pupilId);
  }

  @Override
  public void deleteById(Integer pupilId) {
    repository.deleteById(pupilId);
  }

  @Override
  public Page<PupilEntity> findAll(Pageable pageable) {
    return repository.findAll(pageable);
  }

  @Override
  public PupilEntity save(PupilEntity entity) {
    return repository.save(entity);
  }

  @Override
  public Page<PupilEntity> findByFirstNameLikeAndLastNameLike(String firstName, String lastName, Pageable pageable) {
    return repository.findByFirstNameLikeAndLastNameLike(firstName, lastName, pageable);
  }

  @Override
  public Page<PupilEntity> findByPupilEntity_Id(Integer classId) {
    return repository.findByClassEntity_Id(classId);
  }

  @Override
  public Page<PupilEntity> findByPupilEntity_Level(Integer level) {
    return repository.findByClassEntity_Level(level);
  }
}