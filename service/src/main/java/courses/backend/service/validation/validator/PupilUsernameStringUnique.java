package courses.backend.service.validation.validator;

import courses.backend.db.provider.PupilProvider;
import courses.backend.service.model.PupilDto;
import courses.backend.service.validation.PupilUsernameUnique;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PupilUsernameStringUnique implements ConstraintValidator<PupilUsernameUnique, PupilDto> {

  private final PupilProvider provider;

  public PupilUsernameStringUnique(PupilProvider provider) {
    this.provider = provider;
  }

  @Override
  public boolean isValid(PupilDto value, ConstraintValidatorContext context) {
    if (value == null || value.getUsername() == null) {
      return true;
    }
    return provider.isUsernameUnique(value.getUsername());
  }
}
