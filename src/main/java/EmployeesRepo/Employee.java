package EmployeesRepo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    Integer age;
    @ManyToMany(cascade=CascadeType.PERSIST)
    Set<Skill> skillSet;

    public Employee(String name, Integer age, Set<Skill> skillSet) {
        this.name = name;
        this.age = age;
        this.skillSet = skillSet;
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

    public Set<Skill> getSkillSet() {
        return skillSet;
    }

    public void setSkillSet(Set<Skill> skillSet) {
        this.skillSet = skillSet;
    }
}
