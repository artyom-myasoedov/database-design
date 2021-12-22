package courses.backend.db.provider.impl;

import courses.backend.db.entity.LessonNumber;
import courses.backend.db.entity.Subject;
import courses.backend.db.entity.TimetableRecordEntity;
import courses.backend.db.entity.WeekDay;
import courses.backend.db.provider.TimetableRecordProvider;
import courses.backend.db.repository.TimetableRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TimetableRecordProviderImpl implements TimetableRecordProvider {

  private final TimetableRecordRepository repository;

  @Autowired
  public TimetableRecordProviderImpl(TimetableRecordRepository repository) {
    this.repository = repository;
  }

  @Override
  public Optional<TimetableRecordEntity> findById(Integer timetableId) {
    return repository.findById(timetableId);
  }

  @Override
  public void deleteById(Integer timetableId) {
    repository.deleteById(timetableId);
  }

  @Override
  public Page<TimetableRecordEntity> findAll(Pageable pageable) {
    return repository.findAll(pageable);
  }

  @Override
  public TimetableRecordEntity save(TimetableRecordEntity entity) {
    entity.getClassEntity().setId(2);
    return repository.save(entity);
  }

  @Override
  public Page<TimetableRecordEntity> findByClassEntity_LevelAndClassEntity_Name(Integer level, String name, Pageable pageable) {
    return repository.findByClassEntity_LevelAndClassEntity_Name(level, name, pageable);
  }

  @Override
  public Page<TimetableRecordEntity> findByTeacher_Id(Integer teacherId, Pageable pageable) {
    return repository.findByTeacher_Id(teacherId, pageable);
  }

  @Override
  public Page<TimetableRecordEntity> findByTeacher_FirstNameLikeAndTeacher_LastNameLike(String firstName, String lastName, Pageable pageable) {
    return repository.findByTeacher_FirstNameLikeAndTeacher_LastNameLike(firstName, lastName, pageable);
  }

  @Override
  public Page<TimetableRecordEntity> findBySubject(Subject subject, Pageable pageable) {
    return repository.findBySubject(subject, pageable);
  }

  @Override
  public Page<TimetableRecordEntity> findByWeekDayAndLessonNumber(WeekDay weekDay, LessonNumber lessonNumber, Pageable pageable) {
    return repository.findByWeekDayAndLessonNumber(weekDay, lessonNumber, pageable);
  }
}
