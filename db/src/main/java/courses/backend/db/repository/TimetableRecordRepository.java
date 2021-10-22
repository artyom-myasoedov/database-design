package courses.backend.db.repository;

import courses.backend.db.entity.LessonNumber;
import courses.backend.db.entity.Subject;
import courses.backend.db.entity.TimetableRecordEntity;
import courses.backend.db.entity.WeekDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TimetableRecordRepository extends JpaRepository<TimetableRecordEntity, Integer> {

  Collection<TimetableRecordEntity> findByClassEntity_LevelAndClassEntity_Name(Integer level, String name);

  Collection<TimetableRecordEntity> findByTeacher_Id(Integer teacherId);

  Collection<TimetableRecordEntity> findByTeacher_FirstNameLikeAndTeacher_LastNameLike(String firstName, String lastName);

  Collection<TimetableRecordEntity> findBySubject(Subject subject);

  Collection<TimetableRecordEntity> findByWeekDayAndLessonNumber(WeekDay weekDay, LessonNumber lessonNumber);

}
