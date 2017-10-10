package dao;

import model.Man;
import model.Woman;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

public class ManDao {

    private static Session session;

    public static void save(Man man){
        session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(man);
        session.getTransaction().commit();
        session.close();
    }


    public static void update(String string,Man man){
        session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(string,man);
        session.getTransaction().commit();
        session.close();
    }

    public static void delete(Man man){
        session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(man);
        session.getTransaction().commit();
        session.close();
    }

    public static Man getById(Long id) {
        session = HibernateUtil.getSession();
        return session.get(Man.class,id);
    }

    public static List getAll(){
        session = HibernateUtil.getSession();

        return session.createQuery("FROM Man").list();

    }
}
