package dao;

import model.Woman;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

public class WomanDao {

    private static Session session;

    public static void save(Woman woman){
        session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(woman);
        session.getTransaction().commit();
        session.close();
    }

    public static void update(String string,Woman woman){
        session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(string,woman);
        session.getTransaction().commit();
        session.close();
    }

    public static void delete(Woman woman){
        session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(woman);
        session.getTransaction().commit();
        session.close();
    }

    public static Woman getById(Long id) {
        session = HibernateUtil.getSession();
        return session.get(Woman.class,id);
    }

    public static List getAll(){
        session = HibernateUtil.getSession();
        try {
            return session.createQuery("FROM Woman").list();
        }
        catch (Exception e){
            return  new ArrayList<Entity>();
        }
    }
}
