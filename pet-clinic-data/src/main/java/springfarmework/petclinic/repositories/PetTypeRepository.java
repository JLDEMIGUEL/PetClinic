package springfarmework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springfarmework.petclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
