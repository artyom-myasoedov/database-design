package courses.backend.service.model;

import courses.backend.db.entity.Subject;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

public class TeacherDto extends UserDto {

  private String education;

  @NotNull(message = "subjects-are-null")
  private List<Subject> subjects;

  public String getEducation() {
    return education;
  }

  public void setEducation(String education) {
    this.education = education;
  }

  public List<Subject> getSubjects() {
    return subjects;
  }

  public void setSubjects(List<Subject> subjects) {
    this.subjects = subjects;
  }

  public String getSubjectString() {
    return subjects.stream().map(Subject::toString).collect(Collectors.joining(",\n"));
  }

}
