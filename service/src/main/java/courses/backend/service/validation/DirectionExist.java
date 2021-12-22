package courses.backend.service.validation;

import courses.backend.service.validation.validator.DirectionExistValidator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
  validatedBy = {
    DirectionExistValidator.class
  })
public @interface DirectionExist {

  String message() default "invalid-direction-name";

  Class<? extends Payload>[] payload() default {};

  Class<?>[] groups() default {};
}
