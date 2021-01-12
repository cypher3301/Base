package study.hibernate;

//import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
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
        SessionFactory sessionFactory = new Configuration().buildSessionFactory();
//        Session session =sessionFactory.openSession();

    }

    private void transaction(SessionFactory sessionFactory){
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
}
