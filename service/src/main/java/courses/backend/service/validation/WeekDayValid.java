package courses.backend.service.validation;



import courses.backend.service.validation.validator.WeekDayValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
  validatedBy = {
    WeekDayValidator.class
  })
public @interface WeekDayValid {

  String message() default "invalid-weekDay-name";

  Class<? extends Payload>[] payload() default {};

  Class<?>[] groups() default {};
}
