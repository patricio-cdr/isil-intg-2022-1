package pe.isil.service;

import org.springframework.stereotype.Service;
import pe.isil.model.Student;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentFakeService {

    List<Student> studentList = new ArrayList<>(
            Arrays.asList(
                    new Student("0000001", "Jose", "Ventura", LocalDate.of(1990,3,31)),
                    new Student("0000002", "Maria", "Fernandez", LocalDate.of(1995,5,16))
            )
    );

    public List<Student> read(){
        return studentList;
    }

    public void create(Student student){
        studentList.add(student);
    }

    public void delete(Student student){
        studentList.remove(student);
    }

    public void update(Student student){
        String documentNumber = student.getDocumentNumber();
        Student currentStudent = findById(documentNumber);
        int index = studentList.indexOf(currentStudent);
        studentList.set(index,student);
    }

    public Student findById(String documentNumber) {

        Student student = studentList.stream()
                .filter(s -> s.getDocumentNumber().equalsIgnoreCase(documentNumber))
                .findFirst()
                .orElseGet(null);

        return student;
    }


}
