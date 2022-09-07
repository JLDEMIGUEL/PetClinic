package springfarmework.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import springfarmework.petclinic.model.Owner;


public interface OwnerRepository extends CrudRepository<Owner,Long> {

    Owner findByLastName(String lastName);


}
