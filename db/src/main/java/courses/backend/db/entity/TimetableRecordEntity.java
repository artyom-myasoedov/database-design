package courses.backend.db.entity;

import javax.persistence.*;

@Entity(name = "timetable_record")
@Table(schema = "school", name = "timetable")
public class TimetableRecordEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "timetable_id")
  private Integer id;

  @OneToOne
  @JoinColumn(name = "class_id",
    referencedColumnName = "class_id")
  private ClassEntity classEntity;

  @OneToOne
  @JoinColumn(name = "teacher_id",
    referencedColumnName = "teacher_id")
  private TeacherEntity teacher;

  @Column(name = "day_of_week_id")
  private WeekDay weekDay;

  @Column(name = "subject_id")
  private Subject subject;

  @Column(name = "lesson_number")
  private LessonNumber lessonNumber;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ClassEntity getClassEntity() {
    return classEntity;
  }

  public void setClassEntity(ClassEntity classEntity) {
    this.classEntity = classEntity;
  }

  public TeacherEntity getTeacher() {
    return teacher;
  }

  public void setTeacher(TeacherEntity teacher) {
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
