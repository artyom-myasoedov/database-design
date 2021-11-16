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
  public Optional<PupilEntity> findById(Integer id) {
    return repository.findById(id);
  }

  @Override
  public void deleteById(Integer id) {
    repository.deleteById(id);
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
  public Page<PupilEntity> findByPupilEntity_ClassId(Integer classId, Pageable pageable) {
    return repository.findByClassEntity_Id(classId, pageable);
  }

  @Override
  public Page<PupilEntity> findByPupilEntity_Level(Integer level, Pageable pageable) {
    return repository.findByClassEntity_Level(level, pageable);
  }
}
