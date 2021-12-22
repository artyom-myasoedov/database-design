package courses.backend.service.model;

import courses.backend.service.model.marker.OnCreate;
import courses.backend.service.model.marker.OnUpdate;

import javax.validation.constraints.*;

public class ClassDto {

  @Null(groups = OnCreate.class, message = "classId-is-not-null")
  @NotNull(groups = OnUpdate.class, message = "classId-is-null")
  private Integer id;

  @NotNull(message = "classroomTeacher-is-null")
  private TeacherDto classroomTeacher;

  @NotNull(message = "program-is-null")
  private ProgramDto program;

  @NotBlank(message = "name-is-blank")
  @Size(max = 1, min = 1, message = "nameLength-out-of-range")
  private String name;

  @NotNull(message = "level-is-null")
  @Min(value = 1, message = "level-is-less-than-1")
  @Max(value = 11, message = "level-is-more-than-11")
  private Integer level;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public TeacherDto getClassroomTeacher() {
    return classroomTeacher;
  }

  public void setClassroomTeacher(TeacherDto classroomTeacher) {
    this.classroomTeacher = classroomTeacher;
  }

  public ProgramDto getProgram() {
    return program;
  }

  public void setProgram(ProgramDto program) {
    this.program = program;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }
}
