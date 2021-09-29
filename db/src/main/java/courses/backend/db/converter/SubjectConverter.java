package courses.backend.db.converter;

import courses.backend.db.entity.Subject;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class SubjectConverter implements AttributeConverter<Subject, Integer> {

  @Override
  public Integer convertToDatabaseColumn(Subject attribute) {
    return attribute == null ? null : attribute.getId();
  }

  @Override
  public Subject convertToEntityAttribute(Integer dbData) {
    return Subject.fromId(dbData).orElse(null);
  }
}
