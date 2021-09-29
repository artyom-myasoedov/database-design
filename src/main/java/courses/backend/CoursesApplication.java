package courses.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "courses.backend")
public class CoursesApplication {
  public static void main(String[] args) {
    SpringApplication.run(CoursesApplication.class, args);
  }
}
//TODO переделать на школьное расписание, сущности: ученик, учитель, класс, программа, расписание отдельныая таблица с расписанием(временем), расписание  - номера уроков, предметы
