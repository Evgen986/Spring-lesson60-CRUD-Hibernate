package ru.evgen.projectPiople.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

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
    @Pattern(regexp = "[А-Я][а-я]+, [А-Я][а-я]+, \\d{6}", message = "Введите адрес в соответсвии с формой: Страна, Город, индекс (6 цифр)")
    private String address;

    public Person(){

    }
    public Person(int id, String name, int age, String email, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
