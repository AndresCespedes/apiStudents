package ApiStudents.controllers;

import ApiStudents.domain.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController()
@RequestMapping("/students")
public class studentController {

    List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(1726731, "Andres", "andres@hotmail.com", 25, "informática"),
            new Student(1726731, "Sebastian", "sebastian@hotmail.com", 25, "informática"),
            new Student(1726731, "Maria", "maria@hotmail.com", 25, "informática"),
            new Student(1726731, "Esteban", "esteban@hotmail.com", 25, "informática"),
            new Student(1726731, "Juan", "juan@hotmail.com", 25, "informática")
    ));

    @GetMapping
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/{email}")
    public Student getStudentByEmail(@PathVariable String email) {
        for (Student student : students) {
            if (Objects.equals(student.getEmail(), email)) {
                return student;
            }
        }
        return null;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

    @PutMapping
    public Student putStudent(@RequestBody Student student) {
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                s.setName(student.getName());
                s.setAge(student.getAge());
                s.setEmail(student.getEmail());
                s.setCourse(student.getCourse());
                return s;
            }
        }
        return null;
    }

    @PatchMapping
    public Student patchStudent(@RequestBody Student student) {
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                if (student.getName() != null) {
                    s.setName(student.getName());
                }
                if (student.getAge() != 0) {
                    s.setAge(student.getAge());
                }
                if (student.getEmail() != null) {
                    s.setEmail(student.getEmail());
                }
                if (student.getCourse() != null) {
                    s.setCourse(student.getCourse());
                }
                return s;
            }
        }
        return null;
    }

    @DeleteMapping("/id")
    public Student deleteStudent(@PathVariable int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                return student;
            }
        }
        return null;
    }

}
