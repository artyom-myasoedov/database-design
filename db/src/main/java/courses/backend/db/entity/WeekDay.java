package courses.backend.db.entity;

import java.util.Optional;

public enum WeekDay {
  MONDAY(0),
  TUESDAY(1),
  WEDNESDAY(2),
  THURSDAY(3),
  FRIDAY(4),
  SATURDAY(5),
  SUNDAY(6);

  private final Integer id;

  WeekDay(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public static Optional<WeekDay> fromId(Integer id) {
    if (id == null) {
      return Optional.empty();
    }

    for (var value : WeekDay.values()) {
      if (value.id.equals(id)) {
        return Optional.of(value);
      }
    }

    return Optional.empty();
  }
  //TODO добавить уникальные индексы в расписание(один учитель в одно время не может вести несколько предметов, у класса не может быть одновременно два урока и т.д.)
}
