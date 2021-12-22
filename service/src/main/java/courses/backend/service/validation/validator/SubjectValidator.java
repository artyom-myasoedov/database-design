package courses.backend.service.validation.validator;

import courses.backend.db.entity.Subject;
import courses.backend.service.validation.SubjectValid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SubjectValidator implements ConstraintValidator<SubjectValid, String> {
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (value == null) {
      return true;
    }
    try {
      Subject.valueOf(value);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
