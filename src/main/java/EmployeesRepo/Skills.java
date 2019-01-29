package EmployeesRepo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
public class Skills {

    private Map<String, List<Employee>> skills;

    public void addEmpSkill(String skill, Employee emp){
        List<Employee> employees;
        if(skills.containsKey(skill)) {
            employees = skills.get(skill);
        }else{
            employees = new ArrayList<>();
        }

        if(!employees.contains(emp)) {
            employees.add(emp);
        }

        skills.put(skill,employees);
    }

    public void removeEmpSkill(String skill,Employee emp){
        //TODO: write remove skill for given Employee
    }

    public Skills(Map<String, List<Employee>> skills) {
        this.skills = skills;
    }

    public Skills() {
    }

    public Map<String, List<Employee>> getSkills() {
        return skills;
    }

    public void setSkills(Map<String, List<Employee>> skills) {
        this.skills = skills;
    }
}
