package ru.evgen.projectPiople.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.evgen.projectPiople.model.Person;

@Component
public class PersonValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        if (person.getDateOfBirth() == null) errors.rejectValue("dateOfBirth", "", "Введена некорректная дата рождения!");
    }
}
