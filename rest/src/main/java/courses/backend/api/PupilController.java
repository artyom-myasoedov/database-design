package courses.backend.api;

import courses.backend.service.logic.ClassService;
import courses.backend.service.logic.PupilService;
import courses.backend.service.logic.TimetableRecordService;
import courses.backend.service.model.PageDto;
import courses.backend.service.model.PupilDto;
import courses.backend.service.model.TimetableRecordDto;
import courses.backend.service.model.marker.OnCreate;
import courses.backend.service.model.marker.OnUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/pupil")
@Validated
public class PupilController {

  private final PupilService service;

  private final ClassService classProvider;

  private final TimetableRecordService timetableRecordService;

  @Autowired
  public PupilController(PupilService service, ClassService classService, TimetableRecordService timetableRecordService) {
    this.service = service;
    this.classProvider = classService;
    this.timetableRecordService = timetableRecordService;
  }

  @GetMapping(path = "/{id}")
  PupilDto findById(@PathVariable Integer id) {
    return service.findById(id);
  }

//  @DeleteMapping(path = "/{id}")
//  void deleteById(@PathVariable Integer id) {
//    service.deleteById(id);
//  }

  @GetMapping(path = "/deleteById")
  String deleteById(@RequestParam Integer id, Model model) {
    service.deleteById(id);
    model.addAttribute("pupils",
      service.findAll(0, 100).getItems());
    return "pupils";
  }

  @GetMapping(path = "/addingPage")
  String getAddingPage() {
    return "addPupil";
  }

  @PostMapping(path = "/addPupil")
  public String addTeacher(PupilDto pupilDto, String className, Model model) {
    if (service.findAll(0, 100).getItems()
      .stream().noneMatch(it -> it.getClassDto().equals(className)))
      throw new IllegalArgumentException("invalid class");
    pupilDto.setClassEntity(classProvider.findAllEntities(0, 1).getItems().get(0));
    pupilDto.setPassword("1111");
    service.save(pupilDto);
    model.addAttribute("pupils", service.findAll(0, 100).getItems());
    return "pupils";
  }

  @GetMapping(path = "/getTimetable")
  String getTimetable(@RequestParam Integer id, Model model) {
    PupilDto pupilDto = service.findById(id);
    List<TimetableRecordDto> records = timetableRecordService.findAll(0, 100).getItems()
      .stream().filter(it -> (it.getClassDto().getLevel() + " " + it.getClassDto().getName()).equals(pupilDto.getClassDto()))
      .collect(Collectors.toList());
    Map<Integer, List<TimetableRecordDto>> map = new HashMap<>();
    for (int i = 0; i < 7; i++) {
      int finalI = i;
      map.putIfAbsent(i, new ArrayList<>());
      map.get(i).addAll(records.stream().filter(it -> it.getWeekDay().getId().equals(finalI)).sorted(Comparator.comparing(it -> it.getLessonNumber().getLessonNumber()))
        .collect(Collectors.toList()));
      model.addAttribute("l" + i + "l", map.get(i));
    }
    return "timetable";
  }

  @GetMapping
  PageDto<PupilDto> findAll(
    @RequestParam(defaultValue = "0") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findAll(pageNumber, pageSize);
  }

  @PostMapping
  @Validated(OnCreate.class)
  PupilDto addPupil(@RequestBody @Valid PupilDto dto) {
    return service.save(dto);
  }

  @PutMapping
  @Validated(OnUpdate.class)
  PupilDto updatePupil(@RequestBody @Valid PupilDto dto) {
    return service.save(dto);
  }

  @GetMapping(path = "/byFirstNameAndLastName")
  public String findByFirstNameLikeAndLastNameLike(
    @RequestParam(defaultValue = "") String firstName,
    @RequestParam(defaultValue = "") String lastName,
    @RequestParam(defaultValue = "0") Integer pageNumber,
    @RequestParam(defaultValue = "100") Integer pageSize, Model model) {
    model.addAttribute("pupils", service.findAll(0, 100).getItems()
      .stream().filter(it -> it.getFirstName().contains(firstName) && it.getLastName().contains(lastName))
      .collect(Collectors.toList()));
    return "pupils";
  }

  @GetMapping(path = "/findAndSort")
  public String findAndSort(
    @RequestParam(defaultValue = "") String firstName,
    @RequestParam(defaultValue = "") String lastName,
    @RequestParam(defaultValue = "0") Integer pageNumber,
    @RequestParam(defaultValue = "100") Integer pageSize, Model model) {
    model.addAttribute("pupils", service.findAll(0, 100).getItems()
      .stream().filter(it -> it.getFirstName().contains(firstName) && it.getLastName().contains(lastName))
      .sorted(Comparator.comparing(it -> it.getLastName() + " " + it.getFirstName()))
      .collect(Collectors.toList()));
    return "pupils";
  }

  @GetMapping(path = "/byClassId")
  PageDto<PupilDto> findByPupilEntity_ClassId(
    @RequestParam @NotNull(message = "classId-is-null") Integer classId,
    @RequestParam(defaultValue = "0") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findByPupilEntity_ClassId(classId, pageNumber, pageSize);
  }

  @GetMapping(path = "/byLevel")
  PageDto<PupilDto> findByPupilEntity_Level(
    @RequestParam @Min(value = 1, message = "level-less-than-1") @Max(value = 11, message = "level-more-than-11") @NotNull(message = "level-is-null") Integer level,
    @RequestParam(defaultValue = "0") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findByPupilEntity_Level(level, pageNumber, pageSize);
  }
}
