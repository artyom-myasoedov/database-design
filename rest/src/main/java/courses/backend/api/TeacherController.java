package courses.backend.api;

import courses.backend.service.logic.TeacherService;
import courses.backend.service.model.PageDto;
import courses.backend.service.model.TeacherDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.Subject;
import java.util.List;

@RestController
@RequestMapping(path = "/teacher")
public class TeacherController {

  private final TeacherService service;

  @Autowired
  public TeacherController(TeacherService service) {
    this.service = service;
  }

  @GetMapping(path = "/{id}")
  TeacherDto findById(@PathVariable Integer id) {
    return service.findById(id);
  }

  @DeleteMapping(path = "/{id}")
  void deleteById(@PathVariable Integer id) {
    service.deleteById(id);
  }

  @GetMapping
  PageDto<TeacherDto> findAll(
    @RequestParam(defaultValue = "1") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findAll(pageNumber, pageSize);
  }

  @PostMapping
  TeacherDto addPupil(@RequestBody TeacherDto dto) {
    return service.save(dto);
  }

  @PutMapping
  TeacherDto updatePupil(@RequestBody TeacherDto dto) {
    return service.save(dto);
  }

  @GetMapping(path = "/byFirstNameAndLastName")
  PageDto<TeacherDto> findByFirstNameLikeAndLastNameLike(
    @RequestParam String firstName,
    @RequestParam String lastName,
    @RequestParam(defaultValue = "1") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findByFirstNameLikeAndLastNameLike(firstName, lastName, pageNumber, pageSize);
  }

  @GetMapping(path = "/bySubjects")
  PageDto<TeacherDto> findBySubjects(
    @RequestParam List<Integer> subjects,
    @RequestParam(defaultValue = "1") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findBySubjects(subjects, pageNumber, pageSize);
  }
}
