package courses.backend.db.entity;

import java.util.Optional;

public enum Subject {
  MATHEMATICS(0),
  RUSSIAN(1),
  ENGLISH(2),
  BIOLOGY(3),
  HISTORY(4),
  GEOGRAPHY(5),
  LITERATURE(6),
  PHYSICAL_EDUCATION(7),
  SOCIAL_STUDIES(8),
  PHYSICS(9);


  private final Integer id;

  Subject(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public static Optional<Subject> fromId(Integer id) {
    if (id == null) {
      return Optional.empty();
    }

    for (var value : Subject.values()) {
      if (value.id.equals(id)) {
        return Optional.of(value);
      }
    }

    return Optional.empty();
  }
}
