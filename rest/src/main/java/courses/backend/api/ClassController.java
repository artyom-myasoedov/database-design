package courses.backend.api;

import courses.backend.service.logic.ClassService;
import courses.backend.service.model.ClassDto;
import courses.backend.service.model.ComparisonOperation;
import courses.backend.service.model.PageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/class")
public class ClassController {
  // TODO: 15.11.2021 валидации и изменить номер страницы по умолчанию на 0
  private final ClassService service;

  @Autowired
  public ClassController(ClassService service) {
    this.service = service;
  }

  @GetMapping(path = "/{id}")
  public ClassDto findById(@PathVariable(name = "id") Integer classId) {
    return service.findById(classId);
  }

  @DeleteMapping(path = "/{id}")
  public void deleteById(@PathVariable(name = "id") Integer classId) {
    service.deleteById(classId);
  }

  @GetMapping(path = "/all")
  public PageDto<ClassDto> findAll(
    @RequestParam(defaultValue = "1") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findAll(pageNumber, pageSize);
  }

  @PutMapping
  public ClassDto updateClass(@RequestBody ClassDto dto) {
    return service.save(dto);
  }

  @PostMapping
  public ClassDto addClass(@RequestBody ClassDto dto) {
    return service.save(dto);
  }

  @GetMapping(path = "/byLevel")
  public PageDto<ClassDto> findByLevel(
    @RequestParam Integer level,
    @RequestParam ComparisonOperation operation,
    @RequestParam(defaultValue = "1") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findByLevel(level, operation, pageNumber, pageSize);
  }

  @GetMapping(path = "/byDirection")
  public PageDto<ClassDto> findByProgram_Direction(
    @RequestParam Integer direction,
    @RequestParam(defaultValue = "1") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findByProgram_Direction(direction, pageNumber, pageSize);
  }

  @GetMapping(path = "/byName")
  public PageDto<ClassDto> findByName(
    @RequestParam String name,
    @RequestParam(defaultValue = "1") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findByName(name, pageNumber, pageSize);
  }
}
