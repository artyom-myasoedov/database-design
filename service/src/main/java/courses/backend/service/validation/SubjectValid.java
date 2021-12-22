package courses.backend.service.validation;


import courses.backend.service.validation.validator.SubjectValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
  validatedBy = {
    SubjectValidator.class
  })
public @interface SubjectValid {

  String message() default "invalid-subject-name";

  Class<? extends Payload>[] payload() default {};

  Class<?>[] groups() default {};
}
