package courses.backend.service.model;

import courses.backend.db.entity.*;
import courses.backend.service.model.marker.OnCreate;
import courses.backend.service.model.marker.OnUpdate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class TimetableRecordDto {

  @Null(groups = OnCreate.class)
  @NotNull(groups = OnUpdate.class)
  private Integer id;

  @NotNull
  private ClassDto classDto;

  @NotNull
  private TeacherDto teacher;

  @NotNull
  private WeekDay weekDay;

  @NotNull
  private Subject subject;

  @NotNull
  private LessonNumber lessonNumber;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ClassDto getClassDto() {
    return classDto;
  }

  public void setClassDto(ClassDto classDto) {
    this.classDto = classDto;
  }

  public TeacherDto getTeacher() {
    return teacher;
  }

  public void setTeacher(TeacherDto teacher) {
    this.teacher = teacher;
  }

  public WeekDay getWeekDay() {
    return weekDay;
  }

  public void setWeekDay(WeekDay weekDay) {
    this.weekDay = weekDay;
  }

  public Subject getSubject() {
    return subject;
  }

  public void setSubject(Subject subject) {
    this.subject = subject;
  }

  public LessonNumber getLessonNumber() {
    return lessonNumber;
  }

  public void setLessonNumber(LessonNumber lessonNumber) {
    this.lessonNumber = lessonNumber;
  }
}
