package courses.backend.db.converter;

import courses.backend.db.entity.WeekDay;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class WeekDayConverter implements AttributeConverter<WeekDay, Integer> {

  @Override
  public Integer convertToDatabaseColumn(WeekDay attribute) {
    return attribute == null ? null : attribute.getId();
  }

  @Override
  public WeekDay convertToEntityAttribute(Integer dbData) {
    return WeekDay.fromId(dbData).orElse(null);
  }
}
