CREATE SCHEMA school;

CREATE TABLE school.directions
(
    direction_id SERIAL      NOT NULL PRIMARY KEY,
    name         VARCHAR(30) NOT NULL
);

CREATE TABLE school.programs
(
    program_id   SERIAL  NOT NULL PRIMARY KEY,
    level        INTEGER NOT NULL,
    direction_id INTEGER NOT NULL DEFAULT 0 REFERENCES school.directions (direction_id)
);

CREATE TABLE school.teachers
(
    teacher_id SERIAL      NOT NULL PRIMARY KEY,
    username   VARCHAR(30) NOT NULL UNIQUE,
    first_name VARCHAR(30) NOT NULL,
    last_name  VARCHAR(30) NOT NULL,
    password   VARCHAR(60) NOT NULL,
    education  VARCHAR(200),
    photo      BYTEA
);

CREATE TABLE school.classes
(
    class_id             SERIAL     NOT NULL PRIMARY KEY,
    class_name           VARCHAR(1) NOT NULL,
    class_number         INTEGER    NOT NULL,
    program_id           INTEGER    NOT NULL REFERENCES school.programs (program_id),
    classroom_teacher_id INTEGER    NOT NULL REFERENCES school.teachers (teacher_id)
);

CREATE TABLE school.pupils
(
    pupil_id   SERIAL      NOT NULL PRIMARY KEY,
    class_id   INTEGER     NOT NULL REFERENCES school.classes (class_id),
    username   VARCHAR(30) NOT NULL UNIQUE,
    first_name VARCHAR(30) NOT NULL,
    last_name  VARCHAR(30) NOT NULL,
    password   VARCHAR(60) NOT NULL,
    photo      BYTEA
);


CREATE TABLE school.days_of_week
(
    day_of_week_id SERIAL      NOT NULL PRIMARY KEY,
    name_of_day    VARCHAR(20) NOT NULL
);

CREATE TABLE school.subjects
(
    subject_id SERIAL      NOT NULL PRIMARY KEY,
    name       VARCHAR(20) NOT NULL
);

CREATE TABLE school.call_schedule
(
    lesson_number INTEGER NOT NULL PRIMARY KEY,
    start_time    TIME    NOT NULL,
    end_time      TIME    NOT NULL
);

CREATE TABLE school.teachers_subjects
(
    teacher_id INTEGER NOT NULL REFERENCES school.teachers (teacher_id) ON DELETE CASCADE,
    subject_id INTEGER NOT NULL REFERENCES school.subjects (subject_id) ON DELETE CASCADE,
    PRIMARY KEY (teacher_id, subject_id)
);

CREATE TABLE school.timetable
(
    timetable_id   SERIAL  NOT NULL PRIMARY KEY,
    class_id       INTEGER NOT NULL REFERENCES school.classes (class_id) ON DELETE CASCADE,
    day_of_week_id INTEGER REFERENCES school.days_of_week (day_of_week_id) ON DELETE CASCADE,
    subject_id     INTEGER NOT NULL REFERENCES school.subjects (subject_id) ON DELETE CASCADE,
    teacher_id     INTEGER NOT NULL REFERENCES school.teachers (teacher_id),
    lesson_number  INTEGER NOT NULL REFERENCES school.call_schedule (lesson_number),
    UNIQUE (class_id, day_of_week_id, lesson_number),
    UNIQUE (teacher_id, day_of_week_id, lesson_number)
);

CREATE TABLE school.programs_subjects
(
    program_id     INTEGER NOT NULL REFERENCES school.programs (program_id) ON DELETE CASCADE,
    subject_id     INTEGER NOT NULL REFERENCES school.subjects (subject_id) ON DELETE CASCADE,
    hours_per_week INTEGER NOT NULL DEFAULT 0,
        PRIMARY KEY (program_id, subject_id)
);



