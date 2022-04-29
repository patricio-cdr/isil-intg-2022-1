package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@NoArgsConstructor // Nos genera el constructor vacio
@AllArgsConstructor // Nos genera el constructoru full
@Data // Genera getters and setters, el toString, el hashcode
public class Student {


    private String documentNumber;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

}
