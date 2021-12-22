package courses.backend.service.validation;

import courses.backend.service.validation.validator.DirectionExistValidator;
import courses.backend.service.validation.validator.SubjectExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
  validatedBy = {
    SubjectExistValidator.class
  })
public @interface SubjectsValid {

  String message() default "invalid-subject-name";

  Class<? extends Payload>[] payload() default {};

  Class<?>[] groups() default {};
}
