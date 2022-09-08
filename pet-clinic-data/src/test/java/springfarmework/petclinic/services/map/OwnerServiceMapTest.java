package springfarmework.petclinic.services.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springfarmework.petclinic.model.Owner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {


    OwnerServiceMap ownerServiceMap;

    final Long ownerId = 1L;
    final String lastname = "Smith";

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());

        Owner owner = new Owner();
        owner.setId(ownerId);
        owner.setLastName(lastname);

        ownerServiceMap.save(owner);
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = ownerServiceMap.findAll();

        assertEquals(1, ownerSet.size());
    }

    @Test
    void findById() {

        Owner owner = ownerServiceMap.findById(ownerId);

        assertEquals(ownerId,owner.getId());
    }

    @Test
    void saveExistingId() {
        Owner owner2 = new Owner();
        long id = 2L;
        owner2.setId(id);

        Owner savedOwner = ownerServiceMap.save(owner2);

        assertEquals(id,savedOwner.getId());
    }

    @Test
    void saveNoId(){
        Owner owner = new Owner();
        Owner savedOwner = ownerServiceMap.save(owner);
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {

        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner smith = ownerServiceMap.findByLastName(lastname);
        assertNotNull(smith);
        assertEquals(ownerId, smith.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner foo = ownerServiceMap.findByLastName("foo");
        assertNull(foo);

    }
}