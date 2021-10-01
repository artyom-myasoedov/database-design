INSERT INTO school.subjects (subject_id, name)
VALUES (0, 'MATHEMATICS');

INSERT INTO school.subjects (subject_id, name)
VALUES (DEFAULT, 'RUSSIAN');

INSERT INTO school.subjects (subject_id, name)
VALUES (DEFAULT, 'ENGLISH');

INSERT INTO school.subjects (subject_id, name)
VALUES (DEFAULT, 'BIOLOGY');

INSERT INTO school.subjects (subject_id, name)
VALUES (DEFAULT, 'HISTORY');

INSERT INTO school.subjects (subject_id, name)
VALUES (DEFAULT, 'GEOGRAPHY');

INSERT INTO school.subjects (subject_id, name)
VALUES (DEFAULT, 'LITERATURE');

INSERT INTO school.subjects (subject_id, name)
VALUES (DEFAULT, 'PHYSICAL_EDUCATION');

INSERT INTO school.subjects (subject_id, name)
VALUES (DEFAULT, 'SOCIAL_STUDIES');

INSERT INTO school.subjects (subject_id, name)
VALUES (DEFAULT, 'PHYSICS');

INSERT INTO school.directions (direction_id, name)
VALUES (0, 'DEFAULT');

INSERT INTO school.directions (direction_id, name)
VALUES (DEFAULT, 'MATH');

INSERT INTO school.directions (direction_id, name)
VALUES (DEFAULT, 'HUMANITARIAN');

INSERT INTO school.call_schedule (lesson_number, start_time, end_time)
VALUES (12, '18:35:00', '19:20:00');

INSERT INTO school.call_schedule (lesson_number, start_time, end_time)
VALUES (1, '08:00:00', '08:45:00');

INSERT INTO school.call_schedule (lesson_number, start_time, end_time)
VALUES (2, '08:55:00', '09:40:00');

INSERT INTO school.call_schedule (lesson_number, start_time, end_time)
VALUES (3, '09:50:00', '10:35:00');

INSERT INTO school.call_schedule (lesson_number, start_time, end_time)
VALUES (4, '10:45:00', '11:30:00');

INSERT INTO school.call_schedule (lesson_number, start_time, end_time)
VALUES (5, '11:40:00', '12:25:00');

INSERT INTO school.call_schedule (lesson_number, start_time, end_time)
VALUES (6, '12:35:00', '13:20:00');

INSERT INTO school.call_schedule (lesson_number, start_time, end_time)
VALUES (7, '14:00:00', '14:45:00');

INSERT INTO school.call_schedule (lesson_number, start_time, end_time)
VALUES (8, '14:55:00', '15:40:00');

INSERT INTO school.call_schedule (lesson_number, start_time, end_time)
VALUES (9, '15:50:00', '16:35:00');

INSERT INTO school.call_schedule (lesson_number, start_time, end_time)
VALUES (10, '16:45:00', '17:30:00');

INSERT INTO school.call_schedule (lesson_number, start_time, end_time)
VALUES (11, '17:40:00', '18:25:00');

INSERT INTO school.days_of_week (day_of_week_id, name_of_day)
VALUES (0, 'MONDAY');

INSERT INTO school.days_of_week (day_of_week_id, name_of_day)
VALUES (DEFAULT, 'TUESDAY');

INSERT INTO school.days_of_week (day_of_week_id, name_of_day)
VALUES (DEFAULT, 'WEDNESDAY');

INSERT INTO school.days_of_week (day_of_week_id, name_of_day)
VALUES (DEFAULT, 'THURSDAY');

INSERT INTO school.days_of_week (day_of_week_id, name_of_day)
VALUES (DEFAULT, 'FRIDAY');

INSERT INTO school.days_of_week (day_of_week_id, name_of_day)
VALUES (DEFAULT, 'SATURDAY');

INSERT INTO school.days_of_week (day_of_week_id, name_of_day)
VALUES (DEFAULT, 'SUNDAY');

INSERT INTO school.programs (program_id, level, direction_id)
VALUES (0, 11, DEFAULT);

INSERT INTO school.programs (program_id, level, direction_id)
VALUES (1, 9, DEFAULT);

INSERT INTO school.programs (program_id, level, direction_id)
VALUES (2, 9, 1);

INSERT INTO school.teachers (teacher_id, username, first_name, last_name, password, education, photo)
VALUES (DEFAULT, 'dimok', 'Дмитрий', 'Соломатин', '1111', 'ВГУ ФКН 2004', null);

INSERT INTO school.teachers (teacher_id, username, first_name, last_name, password, education, photo)
VALUES (DEFAULT, 'kasparov', 'Гарри', 'Капаров', '1111', 'МГУ МПИ 1987', null);

INSERT INTO school.teachers_subjects (teacher_id, subject_id)
VALUES (1, 0);

INSERT INTO school.teachers_subjects (teacher_id, subject_id)
VALUES (1, 1);

INSERT INTO school.teachers_subjects (teacher_id, subject_id)
VALUES (1, 3);

INSERT INTO school.teachers_subjects (teacher_id, subject_id)
VALUES (2, 4);

INSERT INTO school.teachers_subjects (teacher_id, subject_id)
VALUES (2, 6);

INSERT INTO school.classes (class_id, class_name, class_number, program_id, classroom_teacher_id)
VALUES (DEFAULT, 'a', 9, 2, 1);

INSERT INTO school.classes (class_id, class_name, class_number, program_id, classroom_teacher_id)
VALUES (DEFAULT, 'b', 11, 0, 1);

INSERT INTO school.programs_subjects (program_id, subject_id, hours_per_week)
VALUES (0, 3, 5);

INSERT INTO school.programs_subjects (program_id, subject_id, hours_per_week)
VALUES (0, 4, 5);

INSERT INTO school.programs_subjects (program_id, subject_id, hours_per_week)
VALUES (2, 0, 8);

INSERT INTO school.programs_subjects (program_id, subject_id, hours_per_week)
VALUES (2, 9, 4);

INSERT INTO school.programs_subjects (program_id, subject_id, hours_per_week)
VALUES (2, 1, 3);

INSERT INTO school.pupils (pupil_id, class_id, username, first_name, last_name, password, photo)
VALUES (DEFAULT, 1, 'user1', 'Артём', 'Претков', '1111', null);

INSERT INTO school.pupils (pupil_id, class_id, username, first_name, last_name, password, photo)
VALUES (DEFAULT, 1, 'user2', 'Егор', 'Консулов', '1111', null);

INSERT INTO school.pupils (pupil_id, class_id, username, first_name, last_name, password, photo)
VALUES (DEFAULT, 2, 'user3', 'Денис', 'Воробьёв', '1111', null);

INSERT INTO school.timetable (timetable_id, class_id, day_of_week_id, subject_id, teacher_id, lesson_number)
VALUES (DEFAULT, 1, 1, 0, 1, 3);

INSERT INTO school.timetable (timetable_id, class_id, day_of_week_id, subject_id, teacher_id, lesson_number)
VALUES (DEFAULT, 1, 1, 0, 1, 2);

INSERT INTO school.timetable (timetable_id, class_id, day_of_week_id, subject_id, teacher_id, lesson_number)
VALUES (DEFAULT, 1, 2, 1, 1, 1);

INSERT INTO school.timetable (timetable_id, class_id, day_of_week_id, subject_id, teacher_id, lesson_number)
VALUES (DEFAULT, 2, 1, 4, 2, 5);

INSERT INTO school.timetable (timetable_id, class_id, day_of_week_id, subject_id, teacher_id, lesson_number)
VALUES (DEFAULT, 2, 1, 4, 2, 1);

INSERT INTO school.timetable (timetable_id, class_id, day_of_week_id, subject_id, teacher_id, lesson_number)
VALUES (DEFAULT, 2, 2, 3, 1, 3);

INSERT INTO school.timetable (timetable_id, class_id, day_of_week_id, subject_id, teacher_id, lesson_number)
VALUES (DEFAULT, 2, 2, 3, 1, 4);







