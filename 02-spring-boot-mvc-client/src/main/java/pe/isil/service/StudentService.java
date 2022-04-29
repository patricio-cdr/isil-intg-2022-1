package pe.isil.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pe.isil.model.Student;

import java.net.URI;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class StudentService {

    private static final String URL = "http://localhost:9000/api/students";
    private final RestTemplate restTemplate;

    public StudentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Optional<List<Student> > getAll(){

        ResponseEntity<Student[]> responseEntity = restTemplate.getForEntity(URL, Student[].class);

        if (responseEntity.getStatusCode().equals(HttpStatus.NO_CONTENT) ||
            responseEntity.getStatusCode().equals(HttpStatus.INTERNAL_SERVER_ERROR)){

            log.info("status code: {}", responseEntity.getStatusCode());
            return Optional.empty();

        }
            Student[] students = responseEntity.getBody();
            return Optional.ofNullable(List.of(students));
    }




}
