package ru.evgen.projectPiople.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotNull(message = "Name is not be null!")
    @NotEmpty(message = "Name is not be empty!")
    @Size(min = 2, max = 30, message = "Name is not valid")
    private String name;

    @Column(name = "age")
    @Min( value = 0, message = "Age cannot be negative!")
    private int age;

    @Column(name = "email")
    @NotEmpty(message = "Email is not be empty!")
    @Email(message = "Email is not valid")
    private String email;

    @Column(name = "address")
    // Страна, Город, индекс(6 цифр)
    @Pattern(regexp = "[А-Я][а-я]+, [А-Я][а-я]+, \\d{6}", message = "Введите адрес в соответствии с формой: Страна, Город, индекс (6 цифр)")
    private String address;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

}
