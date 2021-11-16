package courses.backend.service.logic;

import courses.backend.service.model.PageDto;
import courses.backend.service.model.PupilDto;

public interface PupilService {


  PupilDto findById(Integer id);

  void deleteById(Integer id);

  PageDto<PupilDto> findAll(Integer pageNumber, Integer pageSize);

  PupilDto save(PupilDto dto);

  PageDto<PupilDto> findByFirstNameLikeAndLastNameLike(String firstName, String lastName, Integer pageNumber, Integer pageSize);

  PageDto<PupilDto> findByPupilEntity_ClassId(Integer classId, Integer pageNumber, Integer pageSize);

  PageDto<PupilDto> findByPupilEntity_Level(Integer level, Integer pageNumber, Integer pageSize);
}
