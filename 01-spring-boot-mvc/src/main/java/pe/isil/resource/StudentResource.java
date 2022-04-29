package pe.isil.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.model.Student;
import pe.isil.service.StudentService;

import java.util.List;

@RequestMapping("/api")
@RestController
public class StudentResource {

    private final StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    // Obtener todos los estudiantes
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents(){

        List<Student> students = studentService.read();
        if (students.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    // Obtener un estudiante por su identificador
    @GetMapping("/students/{documentNumber}")
    public ResponseEntity<Student> getStudentByDocumentNumber(@PathVariable String documentNumber){

        return studentService.readById(documentNumber)
                .map(student -> new ResponseEntity<>(student, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));

    }

    // Guardar un nuevo estudiante
    @PostMapping("/students")
    public ResponseEntity<Student> postStudent(@RequestBody Student student){

        studentService.create(student);

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // Actualizar un estudiante
    @PutMapping("/students/{documentNumber}")
    public ResponseEntity<Student> putStudent(@RequestBody Student student,
                                              @PathVariable String documentNumber){

        return studentService.readById(documentNumber)
                .map(currentStudent -> {
                    student.setDocumentNumber(documentNumber);
                    studentService.update(student);
                    return new ResponseEntity<>(student, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));

    }

    // Borrar un estudiante
    @DeleteMapping("/students/{documentNumber}")
    public ResponseEntity deleteStudent(@PathVariable String documentNumber){

        return studentService.readById(documentNumber)
                .map(s -> {
                    studentService.delete(s);
                    return new ResponseEntity<>(HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));



    }



}
