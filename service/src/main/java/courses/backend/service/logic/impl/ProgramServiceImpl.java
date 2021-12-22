package courses.backend.service.logic.impl;

import courses.backend.db.entity.ClassEntity;
import courses.backend.db.entity.EducationDirection;
import courses.backend.db.entity.ProgramEntity;
import courses.backend.db.provider.ClassProvider;
import courses.backend.db.provider.ProgramProvider;
import courses.backend.service.exception.EntityNotFoundException;
import courses.backend.service.logic.ProgramService;
import courses.backend.service.mapper.ClassMapper;
import courses.backend.service.mapper.ProgramMapper;
import courses.backend.service.model.*;
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
public class ProgramServiceImpl implements ProgramService {

  private final ProgramProvider provider;
  private final ProgramMapper mapper;
  private final Map<ComparisonOperation, BiFunction<Integer, Pageable, Page<ProgramEntity>>> findByLevelFunctions = new HashMap<>();

  @Autowired
  public ProgramServiceImpl(ProgramProvider provider, ProgramMapper mapper) {
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
  public ProgramDto findById(Integer id) {
    return provider.findById(id)
      .map(mapper::fromEntity)
      .orElseThrow(() -> new EntityNotFoundException("ProgramEntity with id: " + id.toString() + "not found"));
  }

  @Override
  public void deleteById(Integer id) {
    provider.deleteById(id);
  }

  @Override
  public PageDto<ProgramDto> findAll(Integer pageNumber, Integer pageSize) {
    var values = provider.findAll(Pageable.ofSize(pageSize).withPage(pageNumber)).map(mapper::fromEntity);

    return ImmutablePageDto.<ProgramDto>builder()
      .pageNumber(pageNumber)
      .totalPages(values.getTotalPages())
      .items(values.getContent())
      .build();
  }

  @Override
  public ProgramDto save(ProgramDto dto) {
    return Optional.of(dto)
      .map(mapper::toEntity)
      .map(provider::save)
      .map(mapper::fromEntity)
      .orElseThrow(() -> new EntityNotFoundException("cannot save ProgramEntity"));
  }

  @Override
  public PageDto<ProgramDto> findByLevel(Integer level, ComparisonOperation operation, Integer pageNumber, Integer pageSize) {
    var values = findByLevelFunctions.get(operation)
      .apply(level, Pageable.ofSize(pageSize).withPage(pageNumber)).map(mapper::fromEntity);

    return ImmutablePageDto.<ProgramDto>builder()
      .pageNumber(pageNumber)
      .totalPages(values.getTotalPages())
      .items(values.getContent())
      .build();
  }

  @Override
  public PageDto<ProgramDto> findByDirection(String direction, Integer pageNumber, Integer pageSize) {
    var values = provider.findByDirection(
        EducationDirection.valueOf(direction),
        Pageable.ofSize(pageSize).withPage(pageNumber))
      .map(mapper::fromEntity);

    return ImmutablePageDto.<ProgramDto>builder()
      .pageNumber(pageNumber)
      .totalPages(values.getTotalPages())
      .items(values.getContent())
      .build();
  }
}
