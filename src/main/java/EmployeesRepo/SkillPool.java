package EmployeesRepo;

import java.util.*;

//@Entity
public class SkillPool {

    private Collection<Skill> skills=new ArrayList<>();

    public Skill internSkill(String skill) {
        if (skills.contains(new Skill(skill))) {
            return getSkill(skill);
        } else {
            Skill newSkill = new Skill(skill);
            skills.add(newSkill);
            return newSkill;
        }
    }

    public Collection<Skill> internSkills(Collection<String> skills) {
        Collection<Skill> pooledSkills = new ArrayList<>();
        skills.forEach(s -> {
                   pooledSkills.add(this.internSkill(s));
                }
        );
        return pooledSkills;
    }

    public boolean contains(String skill) {
        return skills.contains(skill);
    }

    public SkillPool() {
    }

    private Skill getSkill(String skill) {
        Iterator<Skill> iterator = this.skills.iterator();
        while (iterator.hasNext()) {
            Skill nextSkill = iterator.next();
            if (nextSkill.equals(skill)) {
                return nextSkill;
            }
        }
        return null;
    }
}
