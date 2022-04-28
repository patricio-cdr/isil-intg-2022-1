package pe.isil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.isil.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

}
