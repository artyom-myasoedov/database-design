package courses.backend.handler;

import courses.backend.model.ErrorModel;
import courses.backend.model.ValidationError;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandler {

  @org.springframework.web.bind.annotation.ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ErrorModel> handleCvl(ConstraintViolationException e) {
    var errors = e.getConstraintViolations().stream()
      .map(ConstraintViolation::getMessage)
      .map(ValidationError::new)
      .collect(Collectors.toUnmodifiableList());

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorModel(errors));
  }

  @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
  ResponseEntity<ErrorModel> onMethodArgumentNotValidException(
    MethodArgumentNotValidException e) {
    var errors = e.getBindingResult()
      .getFieldErrors().stream()
      .map(DefaultMessageSourceResolvable::getDefaultMessage)
      .map(ValidationError::new)
      .collect(Collectors.toUnmodifiableList());

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorModel(errors));
  }
}
