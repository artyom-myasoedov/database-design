package courses.backend.service.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import courses.backend.service.model.marker.OnCreate;
import courses.backend.service.model.marker.OnUpdate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

public class UserDto {


  @Null(groups = OnCreate.class)
  @NotNull(groups = OnUpdate.class)
  private Integer id;

  @NotBlank
  private String username;

  @NotBlank
  private String firstName;

  @NotBlank
  private String lastName;

  @NotBlank(groups = OnCreate.class)
  @Size(min = 4, groups = OnCreate.class)
  private String password;

  private byte[] photo;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public byte[] getPhoto() {
    return photo;
  }

  public void setPhoto(byte[] photo) {
    this.photo = photo;
  }
}
