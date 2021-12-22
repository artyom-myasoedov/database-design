package courses.backend.api;

import courses.backend.service.logic.TimetableRecordService;
import courses.backend.service.model.PageDto;
import courses.backend.service.model.TimetableRecordDto;
import courses.backend.service.model.marker.OnCreate;
import courses.backend.service.model.marker.OnUpdate;
import courses.backend.service.validation.SubjectValid;
import courses.backend.service.validation.WeekDayValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(path = "/timetableRecord")
@Validated
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
    @RequestParam(defaultValue = "0") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findAll(pageNumber, pageSize);
  }

  @PostMapping
  @Validated(OnCreate.class)
  TimetableRecordDto addTimeTable(@RequestBody TimetableRecordDto dto) {
    return service.save(dto);
  }

  @PutMapping
  @Validated(OnUpdate.class)
  TimetableRecordDto updateTimeTable(@RequestBody @Valid TimetableRecordDto dto) {
    return service.save(dto);
  }

  @GetMapping(path = "/byClassLevelAndName")
  PageDto<TimetableRecordDto> findByClassEntity_LevelAndClassEntity_Name(
    @RequestParam @Min(value = 1, message = "level-less-than-1") @Max(value = 11, message = "level-more-than-11") @NotNull(message = "level-is-null") Integer level,
    @RequestParam @NotBlank(message = "name-is-blank") String name,
    @RequestParam(defaultValue = "0") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findByClassEntity_LevelAndClassEntity_Name(level, name, pageNumber, pageSize);
  }

  @GetMapping(path = "/byTeacherId")
  PageDto<TimetableRecordDto> findByTeacher_Id(
    @RequestParam Integer teacherId,
    @RequestParam(defaultValue = "0") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findByTeacher_Id(teacherId, pageNumber, pageSize);
  }

  @GetMapping(path = "/byTeacherFirstNameAndLastName")
  PageDto<TimetableRecordDto> findByTeacher_FirstNameLikeAndTeacher_LastNameLike(
    @RequestParam @NotBlank(message = "firstName-is-blank") String firstName,
    @RequestParam @NotBlank(message = "lastName-is-blank") String lastName,
    @RequestParam(defaultValue = "0") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findByTeacher_FirstNameLikeAndTeacher_LastNameLike(firstName, lastName, pageNumber, pageSize);
  }

  @GetMapping(path = "/bySubject")
  PageDto<TimetableRecordDto> findBySubject(
    @RequestParam @NotBlank(message = "weekDay-is-blank") @SubjectValid String subject,
    @RequestParam(defaultValue = "0") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findBySubject(subject, pageNumber, pageSize);
  }

  @GetMapping(path = "/byWeekDayAndLessonNumber")
  PageDto<TimetableRecordDto> findByWeekDayAndLessonNumber(
    @RequestParam @NotBlank(message = "weekDay-is-blank") @WeekDayValid String weekDay,
    @RequestParam @Min(value = 1, message = "lessonNumber-is-less-than-1") @Min(value = 12, message = "lessonNumber-is-more-than-12") @NotNull(message = "lessonNumber-is-null") Integer lessonNumber,
    @RequestParam(defaultValue = "0") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findByWeekDayAndLessonNumber(weekDay, lessonNumber, pageNumber, pageSize);
  }

}
