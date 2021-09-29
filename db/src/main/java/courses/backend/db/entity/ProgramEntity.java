package courses.backend.db.entity;

import javax.persistence.*;
import java.util.Map;

@Entity(name = "programs")
@Table(schema = "school", name = "programs")
public class ProgramEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "program_id")
  private Integer id;

  @Column(name = "level")
  private Integer level;

  @Column(name = "direction_id")
  private EducationDirection direction;

  @ElementCollection
  @CollectionTable(schema = "school", name = "programs_subjects",
    joinColumns = {
      @JoinColumn(name = "program_id", referencedColumnName = "program_id")
    })
  @MapKeyColumn(name = "subject_id")
  @Column(name = "hours_per_week")
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
