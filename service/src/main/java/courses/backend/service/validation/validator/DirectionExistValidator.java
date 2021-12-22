package courses.backend.service.validation.validator;

import courses.backend.db.entity.EducationDirection;
import courses.backend.service.validation.DirectionExist;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DirectionExistValidator implements ConstraintValidator<DirectionExist, String> {
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (value == null) {
      return true;
    }
    try {
      EducationDirection.valueOf(value);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
