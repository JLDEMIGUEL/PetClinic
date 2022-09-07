package springfarmework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springfarmework.petclinic.model.Specialty;

public interface SpecialtyRepository extends CrudRepository<Specialty,Long> {
}
