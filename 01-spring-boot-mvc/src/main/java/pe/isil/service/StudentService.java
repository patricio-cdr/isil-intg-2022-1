package pe.isil.service;

import org.springframework.stereotype.Service;
import pe.isil.model.Student;
import pe.isil.repository.StudentRepository;

import java.util.List;
import java.util.Optional;


@Service
public class StudentService implements BaseService<Student, String>{

    private final StudentRepository studentRepository;

    // Instancia la clase StudentRepository la cual es una interface que extiende
    // la interface JPA repository la cual es dueña de los metodos findAll(), save(), delete(), etc.
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void create(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> read() {

        return studentRepository.findAll();

    }

    @Override
    public void update(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delete(Student student) {
        studentRepository.delete(student);
    }

    @Override
    public Optional<Student> readById(String id) {
        return studentRepository.findById(id);
    }
}
