package courses.backend.service.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import courses.backend.service.model.marker.OnCreate;
import courses.backend.service.model.marker.OnUpdate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class UserDto {


  @Null(groups = OnCreate.class, message = "userId-is-not-null")
  @NotNull(groups = OnUpdate.class, message = "userId-is-null")
  private Integer id;

  @NotBlank(message = "username-is-blank")
  private String username;

  @NotBlank(message = "firstname-is-blank")
  private String firstName;

  @NotBlank(message = "lastname-is-blank")
  private String lastName;

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
