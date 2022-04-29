package pe.isil.loader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import pe.isil.model.Student;
import pe.isil.repository.StudentRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Configuration
public class StudentLoader implements CommandLineRunner {

    public final StudentRepository studentRepository;

    public StudentLoader(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Student student1 = new Student("01", "Jose", "Ventura", LocalDate.now());
        Student student2 = new Student("02", "Maria", "Fernandez", LocalDate.now());
        Student student3 = new Student("03", "Juan", "Gonzales", LocalDate.now());

        List<Student> students = Arrays.asList(student1, student2, student3);
        studentRepository.saveAll(students);

    }
}
