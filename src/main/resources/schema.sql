CREATE TABLE STUDENT (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(20),
    address VARCHAR(255)
);

CREATE TABLE COURSE (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    code VARCHAR(50)
);

CREATE TABLE ENROLLMENT (
    student_id BIGINT,
    course_id BIGINT,
    enrollment_date TIMESTAMP,
    status VARCHAR(50),

    FOREIGN KEY (student_id) REFERENCES Student(id),
    FOREIGN KEY (course_id) REFERENCES Course(id),

    PRIMARY KEY (student_id, course_id)
);

CREATE TABLE APP_USER (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    surname VARCHAR(255),
    email VARCHAR(255),
    user_code VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(255),
    status VARCHAR(50),
    is_locked BOOLEAN,
    is_expired BOOLEAN,
    created_date TIMESTAMP
);