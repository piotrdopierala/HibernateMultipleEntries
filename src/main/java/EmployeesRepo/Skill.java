package EmployeesRepo;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Skill {

    @Id
    String name;

    public Skill() {
    }

    public Skill(String name) {
        this.name = name;
    }

    protected String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o == null) return false;
        Class<?> oClass = o.getClass();
        if(oClass == this.getClass()) {
            Skill skill = (Skill) o;
            return Objects.equals(name, skill.name);
        }
        if(oClass == String.class){
            return Objects.equals(this.name,o);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
