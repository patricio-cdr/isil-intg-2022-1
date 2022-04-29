package pe.isil.loader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import pe.isil.service.StudentService;

@Configuration
public class StudentLoader implements CommandLineRunner {

    private final StudentService studentService;

    public StudentLoader(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void run(String... args) throws Exception {

        studentService.getAll()
                .ifPresent(System.out::println);

    }
}
