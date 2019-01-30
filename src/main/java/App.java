import EmployeesRepo.Employee;
import EmployeesRepo.Skill;
import EmployeesRepo.SkillPool;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.*;

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
        SkillPool skillPool = new SkillPool();

        Collection<String> emp1SkillSet = new HashSet<>(Arrays.asList("Java","Excel"));
        generatedEmpsList.add(new Employee("Jan Kowalski",22,skillPool.internSkills(emp1SkillSet)));

        HashSet<String> emp2SkillSet = new HashSet<>(Arrays.asList("Excel"));
        generatedEmpsList.add(new Employee("Anna Skrzypczak",40,skillPool.internSkills(emp2SkillSet)));

        HashSet<String> emp3SkillSet = new HashSet<>(Arrays.asList("Word"));
        generatedEmpsList.add(new Employee("Piotr Buc",45,skillPool.internSkills(emp3SkillSet)));

        HashSet<String> emp4SkillSet = new HashSet<>(Arrays.asList("Java"));
        generatedEmpsList.add(new Employee("Andrzej Ogien",25,skillPool.internSkills(emp4SkillSet)));

        return generatedEmpsList;
    }

    public static SessionFactory configureHibernate() {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Employee.class);
        cfg.addAnnotatedClass(SkillPool.class);
        cfg.addAnnotatedClass(Skill.class);
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        return sessionFactory;
    }
}
