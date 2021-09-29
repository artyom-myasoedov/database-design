package courses.backend.db.entity;

import javax.persistence.*;

@Entity(name = "pupils")
@Table(schema = "school", name = "pupils")
public class PupilEntity extends UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "pupil_id")
  private Integer id;

  public PupilEntity() {
    role = Role.PUPIL;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
