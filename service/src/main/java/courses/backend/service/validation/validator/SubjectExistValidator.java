package courses.backend.service.validation.validator;

import courses.backend.db.entity.Subject;
import courses.backend.service.validation.SubjectsValid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.stream.Collectors;

public class SubjectExistValidator implements ConstraintValidator<SubjectsValid, List<String>> {
  @Override
  public boolean isValid(List<String> value, ConstraintValidatorContext context) {
    if (value == null || value.isEmpty()) {
      return true;
    }
    try {
      var list = value.stream().map(Subject::valueOf).collect(Collectors.toList());
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
