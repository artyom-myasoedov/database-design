package courses.backend.service.model;

import courses.backend.db.entity.EducationDirection;
import courses.backend.db.entity.Subject;
import courses.backend.service.model.marker.OnCreate;
import courses.backend.service.model.marker.OnUpdate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Map;

public class ProgramDto {

  @Null(groups = OnCreate.class)
  @NotNull(groups = OnUpdate.class)
  private Integer id;

  @NotNull
  @Min(value = 1)
  @Max(value = 11)
  private Integer level;

  @NotNull
  private EducationDirection direction;

  @NotNull
  private Map<Subject, Integer> subjectHoursMap;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public EducationDirection getDirection() {
    return direction;
  }

  public void setDirection(EducationDirection direction) {
    this.direction = direction;
  }

  public Map<Subject, Integer> getSubjectHoursMap() {
    return subjectHoursMap;
  }

  public void setSubjectHoursMap(Map<Subject, Integer> subjectHoursMap) {
    this.subjectHoursMap = subjectHoursMap;
  }
}
