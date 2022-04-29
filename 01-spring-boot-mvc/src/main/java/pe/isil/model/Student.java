package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity // API Jpa, mapea esta clase con un simil en base de datos en una tabla.
        // TL;DR crea una tabla en base de datos con los campos @column, basicamente tu clase se
        // convierte en una tabla.
@Table(name = "tbl_student")
@NoArgsConstructor // Nos genera el constructor vacio
@AllArgsConstructor // Nos genera el constructoru full
@Data // Genera getters and setters, el toString, el hashcode
public class Student {

    @Column(length = 8)
    @Id
    private String documentNumber;

    @Column(length = 50)
    private String firstName;

    @Column(length = 100)
    private String lastName;
    private LocalDate birthDate;

}
