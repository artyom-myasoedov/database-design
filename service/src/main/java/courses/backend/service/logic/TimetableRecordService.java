package courses.backend.service.logic;

import courses.backend.db.entity.LessonNumber;
import courses.backend.db.entity.Subject;
import courses.backend.db.entity.WeekDay;
import courses.backend.service.model.PageDto;
import courses.backend.service.model.TimetableRecordDto;
import org.springframework.data.domain.Page;

public interface TimetableRecordService {


  TimetableRecordDto findById(Integer id);

  void deleteById(Integer id);

  PageDto<TimetableRecordDto> findAll(Integer pageNumber, Integer pageSize);

  TimetableRecordDto save(TimetableRecordDto dto);

  PageDto<TimetableRecordDto> findByClassEntity_LevelAndClassEntity_Name(Integer level, String name, Integer pageNumber, Integer pageSize);

  PageDto<TimetableRecordDto> findByTeacher_Id(Integer teacherId, Integer pageNumber, Integer pageSize);

  PageDto<TimetableRecordDto> findByTeacher_FirstNameLikeAndTeacher_LastNameLike(String firstName, String lastName, Integer pageNumber, Integer pageSize);

  PageDto<TimetableRecordDto> findBySubject(Integer subject, Integer pageNumber, Integer pageSize);

  PageDto<TimetableRecordDto> findByWeekDayAndLessonNumber(Integer weekDay, Integer lessonNumber, Integer pageNumber, Integer pageSize);

}
