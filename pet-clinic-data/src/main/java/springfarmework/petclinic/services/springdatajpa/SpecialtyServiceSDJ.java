package springfarmework.petclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springfarmework.petclinic.model.Specialty;
import springfarmework.petclinic.repositories.SpecialtyRepository;
import springfarmework.petclinic.services.SpecialtyService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialtyServiceSDJ implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtyServiceSDJ(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }


    @Override
    public Set<Specialty> findAll() {

        Set<Specialty> specialties = new HashSet<>();
        specialtyRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long aLong) {
        return specialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Specialty object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialtyRepository.deleteById(aLong);
    }
}
