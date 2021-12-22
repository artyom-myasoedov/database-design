package courses.backend.api;

import courses.backend.service.logic.ProgramService;
import courses.backend.service.model.ComparisonOperation;
import courses.backend.service.model.PageDto;
import courses.backend.service.model.ProgramDto;
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
@RequestMapping(path = "/program")
@Validated
public class ProgramController {

  private final ProgramService service;

  @Autowired
  public ProgramController(ProgramService service) {
    this.service = service;
  }

  @GetMapping(path = "/{id}")
  ProgramDto findById(@PathVariable Integer id) {
    return service.findById(id);
  }

  @DeleteMapping(path = "/{id}")
  void deleteById(@PathVariable Integer id) {
    service.deleteById(id);
  }

  @GetMapping
  PageDto<ProgramDto> findAll(
    @RequestParam(defaultValue = "0") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findAll(pageNumber, pageSize);
  }

  @PostMapping
  @Validated(OnCreate.class)
  ProgramDto addProgram(@RequestBody @Valid ProgramDto dto) {
    return service.save(dto);
  }

  @PutMapping
  @Validated(OnUpdate.class)
  ProgramDto updateProgram(@RequestBody @Valid ProgramDto dto) {
    return service.save(dto);
  }

  @GetMapping(path = "/byLevel")
  PageDto<ProgramDto> findByLevel(
    @RequestParam @Min(value = 1, message = "level-less-than-1") @Max(value = 11, message = "level-more-than-11") @NotNull(message = "level-is-null") Integer level,
    @RequestParam ComparisonOperation operation,
    @RequestParam(defaultValue = "0") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findByLevel(level, operation, pageNumber, pageSize);
  }

  @GetMapping(path = "/byDirection")
  PageDto<ProgramDto> findByDirection(
    @RequestParam @DirectionExist @NotBlank(message = "direction-is-blank") String direction,
    @RequestParam(defaultValue = "0") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findByDirection(direction, pageNumber, pageSize);
  }

}
