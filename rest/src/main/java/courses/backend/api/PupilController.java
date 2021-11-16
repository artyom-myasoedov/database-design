package courses.backend.api;

import courses.backend.service.logic.PupilService;
import courses.backend.service.model.PageDto;
import courses.backend.service.model.PupilDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/pupil")
public class PupilController {

  private final PupilService service;

  @Autowired
  public PupilController(PupilService service) {
    this.service = service;
  }

  @GetMapping(path = "/{id}")
  PupilDto findById(@PathVariable Integer id) {
    return service.findById(id);
  }

  @DeleteMapping(path = "/{id}")
  void deleteById(@PathVariable Integer id) {
    service.deleteById(id);
  }

  @GetMapping
  PageDto<PupilDto> findAll(
    @RequestParam(defaultValue = "1") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findAll(pageNumber, pageSize);
  }

  @PostMapping
  PupilDto addPupil(@RequestBody PupilDto dto) {
    return service.save(dto);
  }

  @PutMapping
  PupilDto updatePupil(@RequestBody PupilDto dto) {
    return service.save(dto);
  }

  @GetMapping(path = "/byFirstNameAndLastName")
  PageDto<PupilDto> findByFirstNameLikeAndLastNameLike(
    @RequestParam String firstName,
    @RequestParam String lastName,
    @RequestParam(defaultValue = "1") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findByFirstNameLikeAndLastNameLike(firstName, lastName, pageNumber, pageSize);
  }

  @GetMapping(path = "/byClassId")
  PageDto<PupilDto> findByPupilEntity_ClassId(
    @RequestParam Integer classId,
    @RequestParam(defaultValue = "1") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findByPupilEntity_ClassId(classId, pageNumber, pageSize);
  }

  @GetMapping(path = "/byLevel")
  PageDto<PupilDto> findByPupilEntity_Level(
    @RequestParam Integer level,
    @RequestParam(defaultValue = "1") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findByPupilEntity_Level(level, pageNumber, pageSize);
  }
}
