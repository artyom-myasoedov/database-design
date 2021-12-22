package courses.backend.api;

import courses.backend.db.entity.ClassEntity;
import courses.backend.db.repository.ClassRepository;
import courses.backend.db.repository.PupilRepository;
import courses.backend.db.repository.TeacherRepository;
import courses.backend.service.logic.TeacherService;
import courses.backend.service.logic.TimetableRecordService;
import courses.backend.service.model.ClassDto;
import courses.backend.service.model.PageDto;
import courses.backend.service.model.TeacherDto;

import courses.backend.service.model.TimetableRecordDto;
import courses.backend.service.model.marker.OnCreate;
import courses.backend.service.model.marker.OnUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/teacher")
@Validated
public class TeacherController {

  private final TeacherService service;
  private final TimetableRecordService timetableRecordService;
  private final TeacherRepository teacherRepository;
  private final PupilRepository pupilRepository;
  private final ClassRepository classRepository;


  @Autowired
  public TeacherController(TeacherService service, TimetableRecordService timetableRecordService, TeacherRepository teacherRepository, PupilRepository pupilRepository, ClassRepository classRepository) {
    this.service = service;
    this.timetableRecordService = timetableRecordService;
    this.teacherRepository = teacherRepository;
    this.pupilRepository = pupilRepository;
    this.classRepository = classRepository;
  }

  @GetMapping(path = "/{id}")
  TeacherDto findById(@PathVariable Integer id) {
    return service.findById(id);
  }

//  @DeleteMapping(path = "/{id}")
//  void deleteById(@PathVariable Integer id) {
//    service.deleteById(id);
//  }

  @GetMapping(path = "/getTimetable")
  String getTimetable(@RequestParam Integer id, Model model) {
    List<TimetableRecordDto> records = timetableRecordService.findAll(0, 100).getItems()
      .stream().filter(it -> it.getTeacher().getId().equals(id)).collect(Collectors.toList());
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

  @GetMapping(path = "/agregate")
  public String agregate(Model model) {
    model.addAttribute("tCount", teacherRepository.count());
    model.addAttribute("pCount", pupilRepository.count());
    model.addAttribute("cCount", classRepository.count());
    model.addAttribute("average", pupilRepository.count() / (double) classRepository.count());
    List<ClassEntity> classDtos = classRepository.findAll();
    String t = "";
    try {
      t = new String("шт".getBytes("windows-1251"));
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
      t = "";
    }
    String finalT = t;
    List<String> classes = classDtos.stream().map(it -> it.getLevel() + " " + it.getName() + ":        " + pupilRepository.countByClassEntity_Id(it.getId()) + finalT).collect(Collectors.toList());
    model.addAttribute("classes", classes);
    return "agregate";
  }
  @GetMapping(path = "/addingPage")
  String getAddingPage() {
    return "addTeacher";
  }

  @PostMapping(path = "/addTeacher")
  public String addTeacher(TeacherDto teacherDto, Model model) {
    teacherDto.setPassword("1111");
    service.save(teacherDto);
    model.addAttribute("teachers", service.findAll(0, 100).getItems());
    return "teachers";
  }

  @GetMapping(path = "/deleteById")
  String deleteById(@RequestParam Integer id, Model model) {
    service.deleteById(id);
    model.addAttribute("teachers",
      service.findAll(0, 100).getItems());
    return "teachers";
  }

  @GetMapping
  PageDto<TeacherDto> findAll(
    @RequestParam(defaultValue = "0") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize) {
    return service.findAll(pageNumber, pageSize);
  }

  @PostMapping
  @Validated(OnCreate.class)
  TeacherDto addPupil(@RequestBody @Valid TeacherDto dto) {
    return service.save(dto);
  }

  @PutMapping
  @Validated(OnUpdate.class)
  TeacherDto updatePupil(@RequestBody @Valid TeacherDto dto) {
    return service.save(dto);
  }

  @GetMapping(path = "/byFirstNameAndLastName")
  public String findByFirstNameLikeAndLastNameLike(
    @RequestParam(defaultValue = "") String firstName,
    @RequestParam(defaultValue = "") String lastName,
    @RequestParam(defaultValue = "0") Integer pageNumber,
    @RequestParam(defaultValue = "100") Integer pageSize, Model model) {
    model.addAttribute("teachers",
      service.findAll(0, 100).getItems().stream()
        .filter(it -> it.getFirstName().contains(firstName) && it.getLastName().contains(lastName))
        .collect(Collectors.toList()));
    return "teachers";
  }

  @GetMapping(path = "/findAndSort")
  public String findAndSort(
    @RequestParam(defaultValue = "") String firstName,
    @RequestParam(defaultValue = "") String lastName,
    @RequestParam(defaultValue = "0") Integer pageNumber,
    @RequestParam(defaultValue = "100") Integer pageSize, Model model) {
    model.addAttribute("teachers",
      service.findAll(0, 100).getItems().stream()
        .filter(it -> it.getFirstName().contains(firstName) && it.getLastName().contains(lastName))
        .sorted(Comparator.comparing(it -> it.getLastName() + " " + it.getFirstName()))
        .collect(Collectors.toList()));
    return "teachers";
  }


  @GetMapping(path = "/bySubjects")
  public String findBySubjects(
    //@RequestParam @NotNull(message = "subjects-are-null") @SubjectsValid List<String> subjects,
    @RequestParam(defaultValue = "0") Integer pageNumber,
    @RequestParam(defaultValue = "5") Integer pageSize,
    Model model) {
    return "teachers";
  }
}
