package courses.backend.service.validation.validator;

import courses.backend.db.entity.WeekDay;
import courses.backend.service.validation.WeekDayValid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class WeekDayValidator implements ConstraintValidator<WeekDayValid, String> {
  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (value == null) {
      return true;
    }
    try {
      WeekDay.valueOf(value);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
