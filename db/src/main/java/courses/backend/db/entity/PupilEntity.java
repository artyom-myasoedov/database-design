package courses.backend.db.entity;

import javax.persistence.*;

@Entity(name = "pupils")
@Table(schema = "school", name = "pupils")
public class PupilEntity extends UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "pupil_id")
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "class_id", referencedColumnName = "class_id")
  private ClassEntity classEntity;

  public PupilEntity() {
    role = Role.PUPIL;
  }

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

  public String getClassInf() {
    return classEntity.getLevel() + " " + classEntity.getName();
  }
}
