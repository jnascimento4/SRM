package br.com.tech.test.srm.controllers;

import br.com.tech.test.srm.dtos.PersonDTO;
import br.com.tech.test.srm.entities.Person;
import br.com.tech.test.srm.repository.PersonRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "Servico", description = "Gerenciamento de Pessoa")
@RestController
@RequestMapping("/people")
public class PersonController {
    private final PersonRepository personRepository;

    private static final String CPF = "CPF";
    private static final String CNPJ = "CNPJ";

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Operation(
            summary = "Cadastro de Pessoa",
            description = "Recebe informações pessoais e salva no banco de dados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping
    public ResponseEntity<String> createPerson(@RequestBody PersonDTO personDTO) {
        if (personDTO.identifier() == null || personDTO.identifier().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O identificador não foi informado.");
        }

        String identifier = personDTO.identifier().replaceAll("[./-]", "");

        if (identifier.length() == 11) {
            // CPF
            Person person = new Person(personDTO.name(), identifier, CPF);
            personRepository.save(person);
            return ResponseEntity.ok("Pessoa cadastrada com sucesso (CPF).");
        } else if (identifier.length() == 14) {
            // CNPJ
            Person person = new Person(personDTO.name(), identifier, CNPJ);
            personRepository.save(person);
            return ResponseEntity.ok("Pessoa cadastrada com sucesso (CNPJ).");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O identificador informado é inválido.");
        }
    }
}
