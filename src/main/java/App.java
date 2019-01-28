import EmployeesRepo.Employee;
import EmployeesRepo.Skill;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello.");

        SessionFactory sessionFactory = configureHibernate();
        try (
                Session session = sessionFactory.openSession();
        ) {
            Transaction transaction = session.beginTransaction();

            generateEmployees().forEach(session::persist);

            transaction.commit();
            sessionFactory.close();
        }

    }

    public static List<Employee> generateEmployees(){
        List<Employee> generatedEmpsList = new ArrayList<>();

        HashSet<Skill> emp1SkillSet = new HashSet<>(Arrays.asList(new Skill("Java"),new Skill("Excel")));
        generatedEmpsList.add(new Employee("Jan Kowalski",22,emp1SkillSet));

        HashSet<Skill> emp2SkillSet = new HashSet<>(Arrays.asList(new Skill("Excel")));
        generatedEmpsList.add(new Employee("Anna Skrzypczak",40,emp2SkillSet));

        HashSet<Skill> emp3SkillSet = new HashSet<>(Arrays.asList(new Skill("Word")));
        generatedEmpsList.add(new Employee("Piotr Buc",45,emp3SkillSet));

        HashSet<Skill> emp4SkillSet = new HashSet<>(Arrays.asList(new Skill("Java")));
        generatedEmpsList.add(new Employee("Andrzej Ogien",25,emp4SkillSet));

        return generatedEmpsList;
    }

    public static SessionFactory configureHibernate() {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Employee.class);
        cfg.addAnnotatedClass(Skill.class);
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        return sessionFactory;
    }
}
