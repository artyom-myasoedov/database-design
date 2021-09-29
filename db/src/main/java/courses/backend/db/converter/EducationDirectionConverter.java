package courses.backend.db.converter;

import courses.backend.db.entity.EducationDirection;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class EducationDirectionConverter implements AttributeConverter<EducationDirection, Integer> {

  @Override
  public Integer convertToDatabaseColumn(EducationDirection attribute) {
    return attribute == null ? null : attribute.getId();
  }

  @Override
  public EducationDirection convertToEntityAttribute(Integer dbData) {
    return EducationDirection.fromId(dbData).orElse(null);
  }
}
