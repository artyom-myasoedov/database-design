CREATE SCHEMA courses;

CREATE TABLE courses.roles
(
  role_id INTEGER NOT NULL PRIMARY KEY,
  role_name VARCHAR(20) NOT NULL
);

CREATE TABLE courses.users
(
    user_id   SERIAL      NOT NULL PRIMARY KEY,
    username   VARCHAR(30) NOT NULL UNIQUE,
    first_name VARCHAR(30) NOT NULL,
    last_name  VARCHAR(30) NOT NULL,
    password   VARCHAR(60) NOT NULL,
    role_id INTEGER NOT NULL REFERENCES courses.roles (role_id),
    photo BYTEA
);

CREATE TABLE courses.courses
(
    course_id SERIAL NOT NULL PRIMARY KEY,
    course_name VARCHAR(50) NOT NULL,
    lecturer_id INTEGER NOT NULL REFERENCES courses.users (user_id),
    cost DECIMAL(3) NOT NULL,
    number_of_hours INTEGER NOT NULL
);

CREATE TABLE courses.groups
(
    group_id SERIAL NOT NULL PRIMARY KEY,
    headman INTEGER REFERENCES courses.users (user_id),
    creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_DATE
);

CREATE TABLE courses.groups_users
(
    group_id INTEGER NOT NULL REFERENCES courses.groups (group_id),
    user_id INTEGER NOT NULL REFERENCES courses.users (user_id)
);

CREATE TABLE courses.groups_courses
(
    group_id INTEGER NOT NULL REFERENCES courses.groups (group_id),
    course_id INTEGER NOT NULL REFERENCES courses.courses (course_id)
);


