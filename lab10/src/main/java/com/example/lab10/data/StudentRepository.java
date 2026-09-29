package com.example.lab10.data;

import com.example.lab10.domain.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findByLastName(String lastName);
    Student findById(long id);

    List<Student> findAll();

    // TODO: Uncomment and complete these when needed
    @Query("SELECT s FROM Student s WHERE s.activeStatus = 1")
    List<Student> findAllActiveStudents();

    @Query("SELECT s FROM Student s ORDER BY s.firstName")
    List<Student> findAllFirstNameSort();
}
