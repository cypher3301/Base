package study.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import study.hibernate.data.HibernateDevelopersEntity;

import java.util.List;

public class DeveloperRunner {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        DeveloperRunner developerRunner = new DeveloperRunner();
        System.out.println("Adding developer's records to the DB");
        /**
         *  Adding developer's records to the database (DB)
         */
        developerRunner.addDeveloper("Proselyte", "Developer", "Java Developer", 2, "apple");
        developerRunner.addDeveloper("Some", "Developer", "C++ Developer", 2,"google");
        developerRunner.addDeveloper("Peter", "UI", "UI Developer", 4,"tesla");

        System.out.println("List of developers");
        /**
         * List developers
         */
        List developers = developerRunner.listDevelopers();
        for (Object developer : developers) {
            HibernateDevelopersEntity developer1 = (HibernateDevelopersEntity) developer;

            System.out.println(developer1.toString());
        }
        System.out.println("===================================");
        System.out.println("Removing Some Developer and updating Proselyte");
        /**
         * Update and Remove developers
         */
        developerRunner.updateDevelopers(2, 3);
//        developerRunner.removeDeveloper(1);
        System.out.println("Final list of developers");
        /**
         * List developers
         */
        developers = developerRunner.listDevelopers();
        for (Object developer : developers) {
            System.out.println(developer.toString());
        }
        System.out.println("===================================");

    }

    public void addDeveloper(String firstname, String lastname, String speciality, int experience, String companyName) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Developer developer = new Developer(firstname, lastname, speciality, experience, new Company(companyName));
        session.save(developer);
        transaction.commit();
        session.close();
    }

    public List listDevelopers() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        List developers = session.createQuery("from HibernateDevelopersEntity ").list();

        transaction.commit();
        session.close();
      return developers;
    }

    public void updateDevelopers(int developerId, int experience) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        Developer developer = (Developer) session.get(Developer.class, developerId);
        developer.setExperience(experience);
        session.update(developer);

        transaction.commit();
        session.close();
    }

    public void removeDeveloper(int developerId){
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        Developer developer = (Developer) session.get(Developer.class, developerId);
        session.delete(developer);

        transaction.commit();
        session.close();
    }

}
