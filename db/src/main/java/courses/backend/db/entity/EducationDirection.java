package courses.backend.db.entity;

import java.util.Optional;

public enum EducationDirection {
  DEFAULT(0),
  MATH(1),
  HUMANITARIAN(2);

  private final Integer id;

  EducationDirection(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public static Optional<EducationDirection> fromId(Integer id) {
    if (id == null) {
      return Optional.empty();
    }

    for (var value : EducationDirection.values()) {
      if (value.id.equals(id)) {
        return Optional.of(value);
      }
    }

    return Optional.empty();
  }
}
