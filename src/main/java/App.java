import EmployeesRepo.Employee;
import EmployeesRepo.Skills;
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
        Skills skills = new Skills();

        HashSet<String> emp1SkillSet = new HashSet<>(Arrays.asList("Java","Excel"));
        generatedEmpsList.add(new Employee("Jan Kowalski",22,emp1SkillSet,skills));

        HashSet<String> emp2SkillSet = new HashSet<>(Arrays.asList("Excel"));
        generatedEmpsList.add(new Employee("Anna Skrzypczak",40,emp2SkillSet,skills));

        HashSet<String> emp3SkillSet = new HashSet<>(Arrays.asList("Word"));
        generatedEmpsList.add(new Employee("Piotr Buc",45,emp3SkillSet,skills));

        HashSet<String> emp4SkillSet = new HashSet<>(Arrays.asList("Java"));
        generatedEmpsList.add(new Employee("Andrzej Ogien",25,emp4SkillSet,skills));

        return generatedEmpsList;
    }

    public static SessionFactory configureHibernate() {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Employee.class);
        cfg.addAnnotatedClass(Skills.class);
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        return sessionFactory;
    }
}
