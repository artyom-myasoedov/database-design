package courses.backend.service.logic.impl;

import courses.backend.db.entity.ClassEntity;
import courses.backend.db.entity.EducationDirection;
import courses.backend.db.provider.ClassProvider;
import courses.backend.service.exception.EntityNotFoundException;
import courses.backend.service.logic.ClassService;
import courses.backend.service.mapper.ClassMapper;
import courses.backend.service.model.ClassDto;
import courses.backend.service.model.ComparisonOperation;
import courses.backend.service.model.ImmutablePageDto;
import courses.backend.service.model.PageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;


@Service
public class ClassServiceImpl implements ClassService {

  private final ClassProvider provider;
  private final ClassMapper mapper;
  private final Map<ComparisonOperation, BiFunction<Integer, Pageable, Page<ClassEntity>>> findByLevelFunctions = new HashMap<>();

  @Autowired
  public ClassServiceImpl(ClassProvider provider, ClassMapper mapper) {
    this.provider = provider;
    this.mapper = mapper;
  }

  @PostConstruct
  public void init() {
    findByLevelFunctions.put(ComparisonOperation.EQUAL, provider::findByLevel);
    findByLevelFunctions.put(ComparisonOperation.LESS_THAN, provider::findByLevelBefore);
    findByLevelFunctions.put(ComparisonOperation.MORE_THAN, provider::findByLevelAfter);
  }


  @Override
  public ClassDto findById(Integer classId) {
    return provider.findById(classId)
      .map(mapper::fromEntity)
      .orElseThrow(() -> new EntityNotFoundException(String.format("ClassEntity with id = %s not found", classId)));
  }

  @Override
  public void deleteById(Integer classId) {
    provider.deleteById(classId);
  }

  @Override
  public PageDto<ClassDto> findAll(Integer pageNumber, Integer pageSize) {
    var values = provider.findAll(Pageable.ofSize(pageSize).withPage(pageNumber)).map(mapper::fromEntity);

    return ImmutablePageDto.<ClassDto>builder()
      .pageNumber(pageNumber)
      .totalPages(values.getTotalPages())
      .items(values.getContent())
      .build();
  }

  @Override
  public ClassDto save(ClassDto dto) {
    return Optional.of(dto)
      .map(mapper::toEntity)
      .map(provider::save)
      .map(mapper::fromEntity)
      .orElseThrow(() -> new EntityNotFoundException("cannot save ClassEntity"));
  }

  @Override
  public PageDto<ClassDto> findByLevel(Integer level, ComparisonOperation operation, Integer pageNumber, Integer pageSize) {
    var values = findByLevelFunctions.get(operation)
      .apply(level, Pageable.ofSize(pageSize).withPage(pageNumber)).map(mapper::fromEntity);

    return ImmutablePageDto.<ClassDto>builder()
      .pageNumber(pageNumber)
      .totalPages(values.getTotalPages())
      .items(values.getContent())
      .build();
  }

  @Override
  public PageDto<ClassDto> findByProgram_Direction(String direction, Integer pageNumber, Integer pageSize) {
    var values = provider.findByProgram_Direction(
        EducationDirection.valueOf(direction),
        Pageable.ofSize(pageSize).withPage(pageNumber))
      .map(mapper::fromEntity);

    return ImmutablePageDto.<ClassDto>builder()
      .pageNumber(pageNumber)
      .totalPages(values.getTotalPages())
      .items(values.getContent())
      .build();
  }

  @Override
  public PageDto<ClassDto> findByName(String name, Integer pageNumber, Integer pageSize) {
    var values = provider.findByName(name, Pageable.ofSize(pageSize).withPage(pageNumber))
      .map(mapper::fromEntity);

    return ImmutablePageDto.<ClassDto>builder()
      .pageNumber(pageNumber)
      .totalPages(values.getTotalPages())
      .items(values.getContent())
      .build();
  }

  @Override
  public PageDto<ClassEntity> findAllEntities(int i, int i1) {
    var values = provider.findAll(Pageable.ofSize(i1).withPage(i));

    return ImmutablePageDto.<ClassEntity>builder()
      .pageNumber(i)
      .totalPages(values.getTotalPages())
      .items(values.getContent())
      .build();
  }
}
