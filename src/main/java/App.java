import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello.");

        SessionFactory sessionFactory = configureHibernate();
        try (
                Session session = sessionFactory.openSession();
        ) {
            //Transaction transaction = session.beginTransaction();

            //transaction.commit();
            sessionFactory.close();
        }

    }

    public static SessionFactory configureHibernate() {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        return sessionFactory;
    }
}
