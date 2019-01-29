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
    @Transient
    Skills skills;


    public Employee(String name, Integer age, Set<String> skillSet,Skills skillDB) {
        this.name = name;
        this.age = age;
        this.skills=skillDB;
        skillSet.forEach(s->this.skills.addEmpSkill(s,this));
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

    public void setSkillSet(Set<String> skillSet) {
        skillSet.forEach(s->this.skills.addEmpSkill(s,this));
    }
}
