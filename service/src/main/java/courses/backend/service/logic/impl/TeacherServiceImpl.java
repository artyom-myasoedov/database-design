package courses.backend.service.logic.impl;

import courses.backend.db.entity.Subject;
import courses.backend.db.provider.PupilProvider;
import courses.backend.db.provider.TeacherProvider;
import courses.backend.service.exception.EntityNotFoundException;
import courses.backend.service.logic.TeacherService;
import courses.backend.service.mapper.PupilMapper;
import courses.backend.service.mapper.TeacherMapper;
import courses.backend.service.model.ImmutablePageDto;
import courses.backend.service.model.PageDto;
import courses.backend.service.model.PupilDto;
import courses.backend.service.model.TeacherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {


  private final TeacherProvider provider;
  private final TeacherMapper mapper;

  @Autowired
  public TeacherServiceImpl(TeacherProvider provider, TeacherMapper mapper) {
    this.provider = provider;
    this.mapper = mapper;
  }

  @Override
  public TeacherDto findById(Integer id) {
    return provider.findById(id)
      .map(mapper::fromEntity)
      .orElseThrow(() -> new EntityNotFoundException("TeacherEntity with id: " + id.toString() + "not found"));
  }

  @Override
  public void deleteById(Integer id) {
    provider.deleteById(id);
  }

  @Override
  public PageDto<TeacherDto> findAll(Integer pageNumber, Integer pageSize) {
    var values = provider.findAll(Pageable.ofSize(pageSize).withPage(pageNumber)).map(mapper::fromEntity);

    return ImmutablePageDto.<TeacherDto>builder()
      .pageNumber(pageNumber)
      .totalPages(values.getTotalPages())
      .items(values.getContent())
      .build();
  }

  @Override
  public TeacherDto save(TeacherDto dto) {
    return Optional.of(dto)
      .map(mapper::toEntity)
      .map(provider::save)
      .map(mapper::fromEntity)
      .orElseThrow(() -> new EntityNotFoundException("cannot save TeacherEntity"));
  }

  @Override
  public PageDto<TeacherDto> findByFirstNameLikeAndLastNameLike(String firstName, String lastName, Integer pageNumber, Integer pageSize) {
    var values = provider.findByFirstNameLikeAndLastNameLike(
        firstName, lastName,
        Pageable.ofSize(pageSize).withPage(pageNumber))
      .map(mapper::fromEntity);

    return ImmutablePageDto.<TeacherDto>builder()
      .pageNumber(pageNumber)
      .totalPages(values.getTotalPages())
      .items(values.getContent())
      .build();
  }

  @Override
  public PageDto<TeacherDto> findBySubjects(List<Integer> subjects, Integer pageNumber, Integer pageSize) {
    var values = provider.findBySubjects(
        subjects.stream().map(s -> Subject.fromId(s).orElseThrow()).collect(Collectors.toList()),
        Pageable.ofSize(pageSize).withPage(pageNumber))
      .map(mapper::fromEntity);

    return ImmutablePageDto.<TeacherDto>builder()
      .pageNumber(pageNumber)
      .totalPages(values.getTotalPages())
      .items(values.getContent())
      .build();
  }
}
