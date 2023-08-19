package ru.evgen.projectPiople.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.evgen.projectPiople.model.Person;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
}
