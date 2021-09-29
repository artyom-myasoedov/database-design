package courses.backend.db.entity;

import java.time.LocalTime;
import java.util.Optional;

public enum LessonNumber {
  FIRST(1, LocalTime.of(8, 0), LocalTime.of(8, 45)),
  SECOND(2, LocalTime.of(8, 55), LocalTime.of(9, 40)),
  THIRD(3, LocalTime.of(9, 50), LocalTime.of(10, 35)),
  FOURTH(4, LocalTime.of(10, 45), LocalTime.of(11, 30)),
  FIFTH(5, LocalTime.of(11, 40), LocalTime.of(12, 25)),
  SIXTH(6, LocalTime.of(12, 35), LocalTime.of(13, 20)),
  SEVENTH(7, LocalTime.of(14, 0), LocalTime.of(14, 45)),
  EIGHTH(8, LocalTime.of(14, 55), LocalTime.of(15, 40)),
  NINTH(9, LocalTime.of(15, 50), LocalTime.of(16, 35)),
  TENTH(10, LocalTime.of(16, 45), LocalTime.of(17, 30)),
  ELEVENTH(11, LocalTime.of(17, 40), LocalTime.of(18, 25)),
  TWELFTH(12, LocalTime.of(18, 35), LocalTime.of(19, 20));

  private final Integer lessonNumber;
  private final LocalTime start;
  private final LocalTime end;

  LessonNumber(int lessonNumber, LocalTime start, LocalTime end) {
    this.lessonNumber = lessonNumber;
    this.start = start;
    this.end = end;
  }

  public int getLessonNumber() {
    return lessonNumber;
  }

  public LocalTime getStart() {
    return start;
  }

  public LocalTime getEnd() {
    return end;
  }

  public static Optional<LessonNumber> fromInt(Integer id) {
    if (id == null) {
      return Optional.empty();
    }

    for (var value : LessonNumber.values()) {
      if (value.lessonNumber.equals(id)) {
        return Optional.of(value);
      }
    }

    return Optional.empty();
  }
}
