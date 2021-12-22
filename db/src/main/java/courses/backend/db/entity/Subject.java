package courses.backend.db.entity;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

public enum Subject {
  MATHEMATICS(0, "Математика"),
  RUSSIAN(1, "Русский язык"),
  ENGLISH(2, "Английский язык"),
  BIOLOGY(3, "Биология"),
  HISTORY(4, "История"),
  GEOGRAPHY(5, "География"),
  LITERATURE(6, "Литература"),
  PHYSICAL_EDUCATION(7, "Физкультура"),
  SOCIAL_STUDIES(8, "Обществознание"),
  PHYSICS(9, "Физика");


  private final Integer id;
  private final String name;

  Subject(Integer id, String name) {
    this.id = id;
    this.name = name;
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

  public String getName() {
    try {
      return new String(name.getBytes("windows-1251"));
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
      return "";
    }
  }
}
