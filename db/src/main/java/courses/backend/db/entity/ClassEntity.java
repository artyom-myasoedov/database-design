package courses.backend.db.entity;

import javax.persistence.*;

@Entity(name = "classes")
@Table(schema = "school", name = "classes")
public class ClassEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "class_id")
  private Integer id;

  @Column(name = "class_name")
  private String name;

  @Column(name = "class_number")
  private Integer number;

  @ManyToOne
  @JoinColumn(name = "program_id",
    referencedColumnName = "program_id",
    insertable = false,
    updatable = false)
  private ProgramEntity program;

  @OneToOne
  @JoinColumn(name = "classroom_teacher_id",
    referencedColumnName = "teacher_id",
    insertable = false,
    updatable = false)
  private TeacherEntity classroomTeacher;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public ProgramEntity getProgram() {
    return program;
  }

  public void setProgram(ProgramEntity program) {
    this.program = program;
  }

  public TeacherEntity getClassroomTeacher() {
    return classroomTeacher;
  }

  public void setClassroomTeacher(TeacherEntity classroomTeacher) {
    this.classroomTeacher = classroomTeacher;
  }
}
