package springfarmework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springfarmework.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
