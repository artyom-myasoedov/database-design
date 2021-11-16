package courses.backend.api;

import courses.backend.service.logic.ProgramService;
import courses.backend.service.model.ComparisonOperation;
import courses.backend.service.model.PageDto;
import courses.backend.service.model.ProgramDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/program")
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
    @RequestParam(defaultValue = "1") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findAll(pageNumber, pageSize);
  }

  @PostMapping
  ProgramDto addProgram(@RequestBody ProgramDto dto) {
    return service.save(dto);
  }

  @PutMapping
  ProgramDto updateProgram(@RequestBody ProgramDto dto) {
    return service.save(dto);
  }

  @GetMapping(path = "/byLevel")
  PageDto<ProgramDto> findByLevel(
    @RequestParam Integer level,
    @RequestParam ComparisonOperation operation,
    @RequestParam(defaultValue = "1") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findByLevel(level, operation, pageNumber, pageSize);
  }

  @GetMapping(path = "/byDirection")
  PageDto<ProgramDto> findByDirection(
    @RequestParam Integer direction,
    @RequestParam(defaultValue = "1") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findByDirection(direction, pageNumber, pageSize);
  }

}
