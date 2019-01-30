package EmployeesRepo;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    Integer age;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    Collection<Skill> skills;


    public Employee(String name, Integer age, Collection<Skill> skillSet) {
        this.name = name;
        this.age = age;
        this.skills = skillSet;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
