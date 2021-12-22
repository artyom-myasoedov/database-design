package courses.backend.api;

import courses.backend.service.logic.ClassService;
import courses.backend.service.model.ClassDto;
import courses.backend.service.model.ComparisonOperation;
import courses.backend.service.model.PageDto;
import courses.backend.service.model.marker.OnCreate;
import courses.backend.service.model.marker.OnUpdate;
import courses.backend.service.validation.DirectionExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(path = "/class")
@Validated
public class ClassController {
  // TODO: 16.11.2021 валидации и изменить Integer в приходящих енамах на строки
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

  @GetMapping
  public PageDto<ClassDto> findAll(
    @RequestParam(defaultValue = "0") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findAll(pageNumber, pageSize);
  }

  @PutMapping
  @Validated(OnUpdate.class)
  public ClassDto updateClass(@RequestBody @Valid ClassDto dto) {
    return service.save(dto);
  }

  @PostMapping
  @Validated(OnCreate.class)
  public ClassDto addClass(@RequestBody @Valid ClassDto dto) {
    return service.save(dto);
  }

  @GetMapping(path = "/byLevel")
  public PageDto<ClassDto> findByLevel(
    @RequestParam @Min(value = 1, message = "level-less-than-1") @Max(value = 11, message = "level-more-than-11") @NotNull(message = "level-is-null") Integer level,
    @RequestParam ComparisonOperation operation,
    @RequestParam(defaultValue = "0") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findByLevel(level, operation, pageNumber, pageSize);
  }

  @GetMapping(path = "/byDirection")
  public PageDto<ClassDto> findByProgram_Direction(
    @RequestParam @DirectionExist @NotBlank(message = "direction-is-blank") String direction,
    @RequestParam(defaultValue = "0") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findByProgram_Direction(direction, pageNumber, pageSize);
  }

  @GetMapping(path = "/byName")
  public PageDto<ClassDto> findByName(
    @RequestParam @NotBlank(message = "name-is-blank") String name,
    @RequestParam(defaultValue = "0") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findByName(name, pageNumber, pageSize);
  }
}
