package courses.backend.db.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "teachers")
@Table(schema = "school", name = "teachers")
public class TeacherEntity extends UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "teacher_id")
  private Integer id;

  @Column(name = "education")
  private String education;

  @ElementCollection(targetClass = Subject.class)
  @JoinTable(schema = "school", name = "teachers_subjects", joinColumns = @JoinColumn(name = "teacher_id"))
  @Enumerated(EnumType.ORDINAL)
  @Column(name = "subject_id")
  private List<Subject> subjects;

  public TeacherEntity() {
    role = Role.TEACHER;
  }

  public List<Subject> getSubjects() {
    return subjects;
  }

  public void setSubjects(List<Subject> subjects) {
    this.subjects = subjects;
  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getEducation() {
    return education;
  }

  public void setEducation(String education) {
    this.education = education;
  }
}
