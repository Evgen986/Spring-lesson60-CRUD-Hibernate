package ru.evgen.projectPiople.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.evgen.projectPiople.model.Person;
import ru.evgen.projectPiople.repositories.PeopleRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    /**
     * Метод получения всех людей из БД
     * @return список людей
     */
    public List<Person> findAll(){
        return peopleRepository.findAll();
    }

    /**
     * Метод получения человека по Id
     * peopleRepository.findById возвращает объект Optional, т.к. человек может быть не найден
     * поэтому в return возвращаем или человека или null.
     * @param id
     * @return
     */
    public Person findOne(int id){
        Optional <Person> person = peopleRepository.findById(id);
        return person.orElse(null);
    }

    /**
     * Метод сохранения человека
     * Аннотация @Transactional над методом имеет приоритет над аннотацией класса
     * и разрешает запись
     * @param person
     */
    @Transactional
    public void save(Person person){
        person.setCreatedAt(new Date());
        peopleRepository.save(person);
    }

    /**
     * Метод изменения человека
     * @param id
     * @param person
     */
    @Transactional
    public void update(int id, Person person){
        person.setId(id); // Присваиваем id человеку, т.к. с формы html человек приходит с не заполненным id
        peopleRepository.save(person);
    }

    /**
     * Удаление человека
     * @param id
     */
    @Transactional
    public void delete(int id){
        peopleRepository.deleteById(id);
    }
}
