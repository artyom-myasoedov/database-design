package courses.backend.service.validation;


import courses.backend.service.validation.validator.TeacherUsernameStringUnique;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
  validatedBy = {
    TeacherUsernameStringUnique.class
  })
public @interface TeacherUsernameUnique {

  String message() default "username.already-exists";

  Class<? extends Payload>[] payload() default {};

  Class<?>[] groups() default {};
}
