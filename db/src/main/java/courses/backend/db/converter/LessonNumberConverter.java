package courses.backend.db.converter;

import courses.backend.db.entity.LessonNumber;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LessonNumberConverter implements AttributeConverter<LessonNumber, Integer> {

  @Override
  public Integer convertToDatabaseColumn(LessonNumber attribute) {
    return attribute == null ? null : attribute.getLessonNumber();
  }

  @Override
  public LessonNumber convertToEntityAttribute(Integer dbData) {
    return LessonNumber.fromInt(dbData).orElse(null);
  }
}
