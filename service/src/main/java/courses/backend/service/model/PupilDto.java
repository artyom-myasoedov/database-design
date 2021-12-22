package courses.backend.service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import courses.backend.db.entity.ClassEntity;

public class PupilDto extends UserDto {

  public String getClassDto() {
    return classDto;
  }

  public void setClassDto(String classDto) {
    this.classDto = classDto;
  }

  private String classDto;

  @JsonIgnore
  private ClassEntity classEntity;

  public ClassEntity getClassEntity() {
    return classEntity;
  }

  public void setClassEntity(ClassEntity classEntity) {
    this.classEntity = classEntity;
  }
}
