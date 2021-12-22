package courses.backend.service.logic.impl;

import courses.backend.db.entity.LessonNumber;
import courses.backend.db.entity.Subject;
import courses.backend.db.entity.WeekDay;
import courses.backend.db.provider.TimetableRecordProvider;
import courses.backend.service.exception.EntityNotFoundException;
import courses.backend.service.logic.TimetableRecordService;
import courses.backend.service.mapper.TimetableRecordMapper;
import courses.backend.service.model.ImmutablePageDto;
import courses.backend.service.model.PageDto;
import courses.backend.service.model.TeacherDto;
import courses.backend.service.model.TimetableRecordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TimetableRecordServiceImpl implements TimetableRecordService {

  private final TimetableRecordProvider provider;
  private final TimetableRecordMapper mapper;

  @Autowired
  public TimetableRecordServiceImpl(TimetableRecordProvider provider, TimetableRecordMapper mapper) {
    this.provider = provider;
    this.mapper = mapper;
  }

  @Override
  public TimetableRecordDto findById(Integer id) {
    return provider.findById(id)
      .map(mapper::fromEntity)
      .orElseThrow(() -> new EntityNotFoundException("TimetableRecordEntity with id: " + id.toString() + "not found"));
  }

  @Override
  public void deleteById(Integer id) {
    provider.deleteById(id);
  }

  @Override
  public PageDto<TimetableRecordDto> findAll(Integer pageNumber, Integer pageSize) {
    var values = provider.findAll(Pageable.ofSize(pageSize).withPage(pageNumber)).map(mapper::fromEntity);

    return ImmutablePageDto.<TimetableRecordDto>builder()
      .pageNumber(pageNumber)
      .totalPages(values.getTotalPages())
      .items(values.getContent())
      .build();
  }

  @Override
  public TimetableRecordDto save(TimetableRecordDto dto) {
    return Optional.of(dto)
      .map(mapper::toEntity)
      .map(provider::save)
      .map(mapper::fromEntity)
      .orElseThrow(() -> new EntityNotFoundException("cannot save TimetableRecordEntity"));
  }

  @Override
  public PageDto<TimetableRecordDto> findByClassEntity_LevelAndClassEntity_Name(Integer level, String name, Integer pageNumber, Integer pageSize) {
    var values = provider.findByClassEntity_LevelAndClassEntity_Name(
        level, name,
        Pageable.ofSize(pageSize).withPage(pageNumber))
      .map(mapper::fromEntity);

    return ImmutablePageDto.<TimetableRecordDto>builder()
      .pageNumber(pageNumber)
      .totalPages(values.getTotalPages())
      .items(values.getContent())
      .build();
  }

  @Override
  public PageDto<TimetableRecordDto> findByTeacher_Id(Integer teacherId, Integer pageNumber, Integer pageSize) {
    var values = provider.findByTeacher_Id(
        teacherId,
        Pageable.ofSize(pageSize).withPage(pageNumber))
      .map(mapper::fromEntity);

    return ImmutablePageDto.<TimetableRecordDto>builder()
      .pageNumber(pageNumber)
      .totalPages(values.getTotalPages())
      .items(values.getContent())
      .build();
  }

  @Override
  public PageDto<TimetableRecordDto> findByTeacher_FirstNameLikeAndTeacher_LastNameLike(String firstName, String lastName, Integer pageNumber, Integer pageSize) {
    var values = provider.findByTeacher_FirstNameLikeAndTeacher_LastNameLike(
        firstName, lastName,
        Pageable.ofSize(pageSize).withPage(pageNumber))
      .map(mapper::fromEntity);

    return ImmutablePageDto.<TimetableRecordDto>builder()
      .pageNumber(pageNumber)
      .totalPages(values.getTotalPages())
      .items(values.getContent())
      .build();
  }

  @Override
  public PageDto<TimetableRecordDto> findBySubject(String subject, Integer pageNumber, Integer pageSize) {
    var values = provider.findBySubject(
        Subject.valueOf(subject),
        Pageable.ofSize(pageSize).withPage(pageNumber))
      .map(mapper::fromEntity);

    return ImmutablePageDto.<TimetableRecordDto>builder()
      .pageNumber(pageNumber)
      .totalPages(values.getTotalPages())
      .items(values.getContent())
      .build();
  }

  @Override
  public PageDto<TimetableRecordDto> findByWeekDayAndLessonNumber(String weekDay, Integer lessonNumber, Integer pageNumber, Integer pageSize) {
    var values = provider.findByWeekDayAndLessonNumber(
        WeekDay.valueOf(weekDay), LessonNumber.fromInt(lessonNumber).orElseThrow(),
        Pageable.ofSize(pageSize).withPage(pageNumber))
      .map(mapper::fromEntity);

    return ImmutablePageDto.<TimetableRecordDto>builder()
      .pageNumber(pageNumber)
      .totalPages(values.getTotalPages())
      .items(values.getContent())
      .build();
  }
}
