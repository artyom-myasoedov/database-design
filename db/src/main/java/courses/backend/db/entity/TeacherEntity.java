package courses.backend.db.entity;

import javax.persistence.*;

@Entity(name = "teachers")
@Table(schema = "school", name = "teachers")
public class TeacherEntity extends UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "teacher_id")
  private Integer id;

  @Column(name = "education")
  private String education;

  public TeacherEntity() {
    role = Role.TEACHER;
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
