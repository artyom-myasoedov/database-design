package courses.backend.service.model;

import courses.backend.service.model.marker.OnCreate;
import courses.backend.service.model.marker.OnUpdate;

import javax.validation.constraints.*;

public class ClassDto {

  @Null(groups = OnCreate.class)
  @NotNull(groups = OnUpdate.class)
  private Integer id;

  @NotNull
  private TeacherDto classroomTeacher;

  @NotNull
  private ProgramDto program;

  @NotBlank
  @Size(max = 1, min = 1)
  private String name;

  @NotNull
  @Min(value = 1)
  @Max(value = 11)
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
