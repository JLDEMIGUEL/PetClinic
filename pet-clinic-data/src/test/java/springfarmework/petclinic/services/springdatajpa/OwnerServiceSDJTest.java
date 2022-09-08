package springfarmework.petclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import springfarmework.petclinic.model.Owner;
import springfarmework.petclinic.repositories.OwnerRepository;
import springfarmework.petclinic.repositories.PetRepository;
import springfarmework.petclinic.repositories.PetTypeRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerServiceSDJTest {

    public static final String LASTNAME = "Smith";
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerServiceSDJ service;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findAll() {

    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findByLastName() {

        Owner returnOwner = new Owner();
        returnOwner.setId(1L);returnOwner.setLastName(LASTNAME);

        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner smith = service.findByLastName(LASTNAME);

        assertEquals(LASTNAME,smith.getLastName());

        verify(ownerRepository).findByLastName(any());
    }
}