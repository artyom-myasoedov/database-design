package courses.backend.service.logic;

import courses.backend.db.entity.Subject;
import courses.backend.service.model.PageDto;
import courses.backend.service.model.TeacherDto;

import java.util.List;

public interface TeacherService {


  TeacherDto findById(Integer id);

  void deleteById(Integer id);

  PageDto<TeacherDto> findAll(Integer pageNumber, Integer pageSize);

  TeacherDto save(TeacherDto dto);

  PageDto<TeacherDto> findByFirstNameLikeAndLastNameLike(String firstName, String lastName, Integer pageNumber, Integer pageSize);

  PageDto<TeacherDto> findBySubjects(List<Integer> subjects, Integer pageNumber, Integer pageSize);

}
