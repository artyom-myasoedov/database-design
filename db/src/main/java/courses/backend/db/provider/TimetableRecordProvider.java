package courses.backend.db.provider;

import courses.backend.db.entity.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TimetableRecordProvider {

  Optional<TimetableRecordEntity> findById(Integer timetableId);

  void deleteById(Integer timetableId);

  Page<TimetableRecordEntity> findAll(Pageable pageable);

  TimetableRecordEntity save(TimetableRecordEntity entity);

  Page<TimetableRecordEntity> findByClassEntity_LevelAndClassEntity_Name(Integer level, String name, Pageable pageable);

  Page<TimetableRecordEntity> findByTeacher_Id(Integer teacherId, Pageable pageable);

  Page<TimetableRecordEntity> findByTeacher_FirstNameLikeAndTeacher_LastNameLike(String firstName, String lastName, Pageable pageable);

  Page<TimetableRecordEntity> findBySubject(Subject subject, Pageable pageable);

  Page<TimetableRecordEntity> findByWeekDayAndLessonNumber(WeekDay weekDay, LessonNumber lessonNumber, Pageable pageable);
}
