package study.hibernate;

//import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import study.hibernate.data.HibernateDevelopersEntity;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import java.util.List;

public class Main {
    private static SessionFactory sessionFactory;
    /*
        1. конфиги
        2. мапинг
            1) xml
            2) annotation
        3. транзакции
        4. ORM
        5. запросы
            1)sql
            2)hql
            3)criteria
    * */
    public static void main(String[] args) {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        new Main().run();

    }

    public void run(){
        nativeSQL();
    }

    private void transaction(){
        Session session =sessionFactory.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();

            ///...your code

            transaction.commit();
        }catch (Exception e){
            if (transaction == null){
                transaction.rollback();
                e.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    private void hql(){
        Session session = sessionFactory.openSession();

        //FROM
        Query query = session.createQuery("FROM HibernateDevelopersEntity ");//load objects into memory
        List developers = query.list();

        //INSERT
        Query query1 = session.createQuery("");//add cast into db table

        //UPDATE
        Query query2 = session.createQuery("UPDATE HibernateDevelopersEntity set experience =: experience WHERE id =: developerId");
        query2.setParameter("experience", 3);

        //DELETE
        Query query3 = session.createQuery("select D.lastName FROM HibernateDevelopersEntity D");
        List developers3 = query3.list();

        //AS
        Query query4 = session.createQuery("FROM HibernateDevelopersEntity as D");
        List developers4 = query4.list();

        //WHERE
        Query query5 = session.createQuery("FROM HibernateDevelopersEntity D WHERE D.id=1");
        List developers5 = query5.list();

        //ORDER BY
        Query query6 = session.createQuery("FROM HibernateDevelopersEntity D WHERE experience > 3 ORDER BY D.experience DESC ");

        //GROUP BY
        Query query7 = session.createQuery("SELECT MAX(D.experience), D.lastName, D.speciality FROM HibernateDevelopersEntity D GROUP BY  D.lastName");
        List developers7 = query7.list();


    }

    private void criteria(){
        Session session = sessionFactory.openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        Root<HibernateDevelopersEntity> root = criteriaBuilder.createQuery(HibernateDevelopersEntity.class).from(HibernateDevelopersEntity.class);
        CriteriaBuilder.In<String> in = criteriaBuilder.in(root.get("experience"));
        System.out.println(in.value("experience"));
        System.out.println();
    }

    private void nativeSQL(){
        Session session = sessionFactory.openSession();
        String sql = "SELECT * FROM hibernate_developers";
        NativeQuery query = session.createNativeQuery(sql);
        query.addEntity(Developer.class);
        List developers = query.list();
        developers.forEach(System.out::println);
//        System.out.println("===============================");
//        for (Object developer : developers) {
//            System.out.println(developer.toString());
//        }
    }

    private void cache(){
        HibernateDevelopersEntity hibernateDevelopersEntity = new HibernateDevelopersEntity();
    }
}
