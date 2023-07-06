package br.com.tech.test.srm;

import br.com.tech.test.srm.controllers.PersonController;
import br.com.tech.test.srm.dtos.PersonDTO;
import br.com.tech.test.srm.entities.Person;
import br.com.tech.test.srm.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PersonControllerTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonController personController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreatePerson_Cpf_Success() {
        PersonDTO personDTO = new PersonDTO("John Doe", "123.456.789-00");

        ResponseEntity<String> response = personController.createPerson(personDTO);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Pessoa cadastrada com sucesso (CPF).", response.getBody());
        verify(personRepository, times(1)).save(any(Person.class));
    }

    @Test
    void testCreatePerson_Cnpj_Success() {
        PersonDTO personDTO = new PersonDTO("ACME Inc", "12.345.678/0000-00");

        ResponseEntity<String> response = personController.createPerson(personDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Pessoa cadastrada com sucesso (CNPJ).", response.getBody());
        verify(personRepository, times(1)).save(any(Person.class));
    }

    @Test
    void testCreatePerson_InvalidIdentifier_Error() {
        PersonDTO personDTO = new PersonDTO("Jane Smith", "123456");

        ResponseEntity<String> response = personController.createPerson(personDTO);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("O identificador informado é inválido.", response.getBody());
        verify(personRepository, never()).save(any(Person.class));
    }

    @Test
    void testCreatePerson_MissingIdentifier_Error() {
        PersonDTO personDTO = new PersonDTO("Bob Johnson", null);

        ResponseEntity<String> response = personController.createPerson(personDTO);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("O identificador não foi informado.", response.getBody());
        verify(personRepository, never()).save(any(Person.class));
    }
}
