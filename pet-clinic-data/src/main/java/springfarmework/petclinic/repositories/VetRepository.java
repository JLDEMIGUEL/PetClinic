package springfarmework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springfarmework.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
