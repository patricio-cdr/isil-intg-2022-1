package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_student")
@NoArgsConstructor
@AllArgsConstructor
@Data
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
