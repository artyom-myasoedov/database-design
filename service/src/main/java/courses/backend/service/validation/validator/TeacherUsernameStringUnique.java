package courses.backend.service.validation.validator;

import courses.backend.db.provider.PupilProvider;
import courses.backend.db.provider.TeacherProvider;
import courses.backend.service.model.TeacherDto;
import courses.backend.service.validation.TeacherUsernameUnique;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TeacherUsernameStringUnique implements ConstraintValidator<TeacherUsernameUnique, TeacherDto> {

  private final TeacherProvider provider;

  public TeacherUsernameStringUnique(TeacherProvider provider) {
    this.provider = provider;
  }
  @Override
  public boolean isValid(TeacherDto value, ConstraintValidatorContext context) {
    if (value == null || value.getUsername() == null) {
      return true;
    }
    return provider.isUsernameUnique(value.getUsername());
  }
}
