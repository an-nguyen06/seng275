package com.example.lab10;

import com.example.lab10.data.StudentRepository;
import com.example.lab10.domain.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Application.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class DatabaseTest {

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    public void setUp(){
        // Optional setup
    }

    @Test
    public void createTest() {
        // TODO: Implement test to verify saving a student
        assertEquals(0, studentRepository.count());
        studentRepository.save(new Student("Able", "Baker", 1));
        assertEquals(1, studentRepository.count());
        Student the_student = studentRepository.findAll().get(0);
        assertEquals(the_student.getFirstName(), "Able");
        assertEquals(the_student.getLastName(), "Baker");
        assertEquals(the_student.getActiveStatus(), 1);

    }


    @Test
    public void deleteTest() {
        // TODO: Implement test to verify deleting a student
        Student student = new Student("John", "Doe", 1);
        studentRepository.save(student);

        assertEquals(1, studentRepository.count());

        studentRepository.delete(student);
        assertEquals(0, studentRepository.count());
    }

    @Test
    public void findByLastNameTest() {
        // TODO: Implement test to find student by last name
        studentRepository.save(new Student("Alice", "Smith", 1));
        studentRepository.save(new Student("Bob", "Jones", 1));
        studentRepository.save(new Student("Carol", "Brown", 0));
        studentRepository.save(new Student("Dave", "Wilson", 1));
        studentRepository.save(new Student("Eve", "Taylor", 0));
        studentRepository.save(new Student("Frank", "Davis", 1));
        assertEquals(6, studentRepository.count());

        List<Student> result = studentRepository.findByLastName("Jones");
        assertEquals(1, result.size());
        assertEquals("Bob", result.get(0).getFirstName());
        assertEquals("Jones", result.get(0).getLastName());
    }

    @Test
    public void updateTest() {
        Student s = new Student("Alice", "Wonder", 1);
        studentRepository.save(s);

        Student retrieved = studentRepository.findAll().get(0);
        assertEquals(1, retrieved.getActiveStatus());

        retrieved.setActiveStatus(0);
        studentRepository.save(retrieved);

        Student updated = studentRepository.findAll().get(0);
        assertEquals(0, updated.getActiveStatus());
    }

    @Test
    public void activeStudentsTest() {
        // TODO: Implement test for active students query
        studentRepository.save(new Student("A", "Smith", 1));
        studentRepository.save(new Student("B", "Jones", 1));
        studentRepository.save(new Student("C", "Brown", 1));
        studentRepository.save(new Student("D", "White", 1));
        studentRepository.save(new Student("E", "Black", 1));
        studentRepository.save(new Student("F", "Green", 1));

        List<Student> result = studentRepository.findByLastName("Brown");

        assertEquals(1, result.size());
        assertEquals("C", result.get(0).getFirstName());
    }

    @Test
    public void sortedFirstNamesTest() {
        // TODO: Implement test for sorting students by first name
        studentRepository.save(new Student("Charlie", "A", 1));
        studentRepository.save(new Student("Alice", "B", 1));
        studentRepository.save(new Student("Eve", "C", 1));
        studentRepository.save(new Student("Bob", "D", 1));
        studentRepository.save(new Student("David", "E", 1));
        studentRepository.save(new Student("Frank", "F", 1));

        List<Student> sorted = studentRepository.findAllFirstNameSort();

        assertEquals("Alice", sorted.get(0).getFirstName());
        assertEquals("Bob", sorted.get(1).getFirstName());
        assertEquals("Charlie", sorted.get(2).getFirstName());
        assertEquals("David", sorted.get(3).getFirstName());
        assertEquals("Eve", sorted.get(4).getFirstName());
        assertEquals("Frank", sorted.get(5).getFirstName());
    }
}

