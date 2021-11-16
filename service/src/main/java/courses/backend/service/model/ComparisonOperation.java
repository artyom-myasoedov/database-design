package courses.backend.service.model;

import courses.backend.db.entity.Subject;

import java.util.Optional;

public enum ComparisonOperation {
  EQUAL(0),
  MORE_THAN(1),
  LESS_THAN(2);

  private Integer id;

  ComparisonOperation(Integer id) {
    this.id = id;
  }

  public static Optional<ComparisonOperation> fromId(Integer id) {
    if (id == null) {
      return Optional.empty();
    }

    for (var value : ComparisonOperation.values()) {
      if (value.id.equals(id)) {
        return Optional.of(value);
      }
    }

    return Optional.empty();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
