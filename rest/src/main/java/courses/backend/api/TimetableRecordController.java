package courses.backend.api;

import courses.backend.service.logic.TimetableRecordService;
import courses.backend.service.model.PageDto;
import courses.backend.service.model.TimetableRecordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/timetableRecord")
public class TimetableRecordController {

  private final TimetableRecordService service;

  @Autowired
  public TimetableRecordController(TimetableRecordService service) {
    this.service = service;
  }

  @GetMapping(path = "/{id}")
  TimetableRecordDto findById(@PathVariable Integer id) {
    return service.findById(id);
  }

  @DeleteMapping(path = "/{id}")
  void deleteById(@PathVariable Integer id) {
    service.deleteById(id);
  }

  @GetMapping
  PageDto<TimetableRecordDto> findAll(
    @RequestParam(defaultValue = "1") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findAll(pageNumber, pageSize);
  }

  @PostMapping
  TimetableRecordDto addPupil(@RequestBody TimetableRecordDto dto) {
    return service.save(dto);
  }

  @PutMapping
  TimetableRecordDto updatePupil(@RequestBody TimetableRecordDto dto) {
    return service.save(dto);
  }

  @GetMapping(path = "/byClassLevelAndName")
  PageDto<TimetableRecordDto> findByClassEntity_LevelAndClassEntity_Name(
    @RequestParam Integer level,
    @RequestParam String name,
    @RequestParam(defaultValue = "1") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findByClassEntity_LevelAndClassEntity_Name(level, name, pageNumber, pageSize);
  }

  @GetMapping(path = "/byTeacherId")
  PageDto<TimetableRecordDto> findByTeacher_Id(
    @RequestParam Integer teacherId,
    @RequestParam(defaultValue = "1") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findByTeacher_Id(teacherId, pageNumber, pageSize);
  }

  @GetMapping(path = "/byTeacherFirstNameAndLastName")
  PageDto<TimetableRecordDto> findByTeacher_FirstNameLikeAndTeacher_LastNameLike(
    @RequestParam String firstName,
    @RequestParam String lastName,
    @RequestParam(defaultValue = "1") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findByTeacher_FirstNameLikeAndTeacher_LastNameLike(firstName, lastName, pageNumber, pageSize);
  }

  @GetMapping(path = "/bySubject")
  PageDto<TimetableRecordDto> findBySubject(
    @RequestParam Integer subject,
    @RequestParam(defaultValue = "1") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findBySubject(subject, pageNumber, pageSize);
  }

  @GetMapping(path = "/byWeekDayAndLessonNumber")
  PageDto<TimetableRecordDto> findByWeekDayAndLessonNumber(
    @RequestParam Integer weekDay,
    @RequestParam Integer lessonNumber,
    @RequestParam(defaultValue = "1") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findByWeekDayAndLessonNumber(weekDay, lessonNumber, pageNumber, pageSize);
  }

}
