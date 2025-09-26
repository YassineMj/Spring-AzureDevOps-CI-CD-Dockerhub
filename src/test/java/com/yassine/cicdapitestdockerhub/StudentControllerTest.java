package com.yassine.cicdapitestdockerhub;

import com.yassine.cicdapitestdockerhub.controller.StudentController;
import com.yassine.cicdapitestdockerhub.model.Student;
import com.yassine.cicdapitestdockerhub.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StudentControllerTest {

    @Test
    void testGetAllStudents() {
        StudentRepository repo = Mockito.mock(StudentRepository.class);
        Mockito.when(repo.findAll()).thenReturn(List.of(new Student("Alice", "alice@test.com")));

        StudentController controller = new StudentController(repo);

        List<Student> result = controller.getAll();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getName()).isEqualTo("Alice");
    }
}
