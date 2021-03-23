package test.service;

import fakhri.chaerul.insan.data.Person;
import fakhri.chaerul.insan.repository.PersonRepository;
import fakhri.chaerul.insan.service.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@Extensions({
        @ExtendWith(MockitoExtension.class)
})
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    private PersonService personService;

    @BeforeEach
    void setUp() {
        personService = new PersonService(personRepository);
    }

    @Test
    void testGetPersonNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            personService.get("not found");
        });
    }

    @Test
    void testGetPersonSuccess() {
        // Menambah behavior ke mock object
        Mockito.when(personRepository.selectById("fakhri"))
                .thenReturn(new Person("fakhri", "Fakhri"));

        Person person = personService.get("fakhri");

        Assertions.assertNotNull(person);
        Assertions.assertEquals("fakhri", person.getId());
        Assertions.assertEquals("Fakhri", person.getName());
    }

    @Test
    void testRegisterSuccess() {
        var person = personService.register("Fakhri");
        Assertions.assertNotNull(person);
        Assertions.assertEquals("Fakhri", person.getName());
        Assertions.assertNotNull(person.getId());

        // Verifikasi pemanggilan data dalam mockito adalah PENTING
        // diusahakan selalu melakukan verifikasi
        Mockito.verify(personRepository, Mockito.times(1))
                .insert(new Person(person.getId(), "Fakhri"));
    }
}
