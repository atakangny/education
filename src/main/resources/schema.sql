CREATE TABLE Student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(20),
    address VARCHAR(255)
);

CREATE TABLE Course (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    code VARCHAR(50)
);

CREATE TABLE Student_Course (
    student_id INT,
    course_id INT,
    enrollment_date TIMESTAMP,
    status VARCHAR(50),

    FOREIGN KEY (student_id) REFERENCES Student(id),
    FOREIGN KEY (course_id) REFERENCES Course(id),

    PRIMARY KEY (student_id, course_id)
);
