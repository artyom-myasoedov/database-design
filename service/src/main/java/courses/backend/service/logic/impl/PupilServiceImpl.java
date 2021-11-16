package courses.backend.service.logic.impl;

import courses.backend.db.entity.EducationDirection;
import courses.backend.db.provider.PupilProvider;
import courses.backend.service.exception.EntityNotFoundException;
import courses.backend.service.logic.PupilService;
import courses.backend.service.mapper.PupilMapper;
import courses.backend.service.model.ImmutablePageDto;
import courses.backend.service.model.PageDto;
import courses.backend.service.model.ProgramDto;
import courses.backend.service.model.PupilDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PupilServiceImpl implements PupilService {

  private final PupilProvider provider;
  private final PupilMapper mapper;

  @Autowired
  public PupilServiceImpl(PupilProvider provider, PupilMapper mapper) {
    this.provider = provider;
    this.mapper = mapper;
  }

  @Override
  public PupilDto findById(Integer id) {
    return provider.findById(id)
      .map(mapper::fromEntity)
      .orElseThrow(() -> new EntityNotFoundException("PupilEntity with id: " + id.toString() + "not found"));
  }

  @Override
  public void deleteById(Integer id) {
    provider.deleteById(id);
  }

  @Override
  public PageDto<PupilDto> findAll(Integer pageNumber, Integer pageSize) {
    var values = provider.findAll(Pageable.ofSize(pageSize).withPage(pageNumber)).map(mapper::fromEntity);

    return ImmutablePageDto.<PupilDto>builder()
      .pageNumber(pageNumber)
      .totalPages(values.getTotalPages())
      .items(values.getContent())
      .build();
  }

  @Override
  public PupilDto save(PupilDto dto) {
    return Optional.of(dto)
      .map(mapper::toEntity)
      .map(provider::save)
      .map(mapper::fromEntity)
      .orElseThrow(() -> new EntityNotFoundException("cannot save PupilEntity"));
  }

  @Override
  public PageDto<PupilDto> findByFirstNameLikeAndLastNameLike(String firstName, String lastName, Integer pageNumber, Integer pageSize) {
    var values = provider.findByFirstNameLikeAndLastNameLike(
        firstName, lastName,
        Pageable.ofSize(pageSize).withPage(pageNumber))
      .map(mapper::fromEntity);

    return ImmutablePageDto.<PupilDto>builder()
      .pageNumber(pageNumber)
      .totalPages(values.getTotalPages())
      .items(values.getContent())
      .build();
  }

  @Override
  public PageDto<PupilDto> findByPupilEntity_ClassId(Integer classId, Integer pageNumber, Integer pageSize) {
    var values = provider.findByPupilEntity_ClassId(
        classId,
        Pageable.ofSize(pageSize).withPage(pageNumber))
      .map(mapper::fromEntity);

    return ImmutablePageDto.<PupilDto>builder()
      .pageNumber(pageNumber)
      .totalPages(values.getTotalPages())
      .items(values.getContent())
      .build();
  }

  @Override
  public PageDto<PupilDto> findByPupilEntity_Level(Integer level, Integer pageNumber, Integer pageSize) {
    var values = provider.findByPupilEntity_Level(
        level,
        Pageable.ofSize(pageSize).withPage(pageNumber))
      .map(mapper::fromEntity);

    return ImmutablePageDto.<PupilDto>builder()
      .pageNumber(pageNumber)
      .totalPages(values.getTotalPages())
      .items(values.getContent())
      .build();
  }
}
