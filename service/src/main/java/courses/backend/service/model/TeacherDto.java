package courses.backend.service.model;

import courses.backend.db.entity.Subject;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class TeacherDto extends UserDto {

  @NotBlank
  private String education;

  @NotNull
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
}
