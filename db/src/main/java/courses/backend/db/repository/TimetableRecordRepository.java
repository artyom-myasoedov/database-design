package courses.backend.db.repository;

import courses.backend.db.entity.LessonNumber;
import courses.backend.db.entity.Subject;
import courses.backend.db.entity.TimetableRecordEntity;
import courses.backend.db.entity.WeekDay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TimetableRecordRepository extends JpaRepository<TimetableRecordEntity, Integer> {

  Page<TimetableRecordEntity> findByClassEntity_LevelAndClassEntity_Name(Integer level, String name, Pageable pageable);

  Page<TimetableRecordEntity> findByTeacher_Id(Integer teacherId, Pageable pageable);

  Page<TimetableRecordEntity> findByTeacher_FirstNameLikeAndTeacher_LastNameLike(String firstName, String lastName, Pageable pageable);

  Page<TimetableRecordEntity> findBySubject(Subject subject, Pageable pageable);

  Page<TimetableRecordEntity> findByWeekDayAndLessonNumber(WeekDay weekDay, LessonNumber lessonNumber, Pageable pageable);

}
