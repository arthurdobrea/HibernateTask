package dao;

import model.Dance;
import model.Man;
import model.Woman;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class DanceDao {

    private static Session session;

    public static void save(Dance dance){
        session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(dance);
        session.getTransaction().commit();
        session.close();
    }

    public static void update(String string, Dance dance){
        session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(string,dance);
        session.getTransaction().commit();
        session.close();
    }

    public static void delete(Dance dance){
        session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(dance);
        session.getTransaction().commit();
        session.close();
    }

    public static Dance getById(Long id) {
        session = HibernateUtil.getSession();
        return session.get(Dance.class,id);
    }

    public static List getAll(){
        session = HibernateUtil.getSession();
        return session.createQuery("FROM Dance").list();

    }

    public static List getAllHisDances(Man man){
        session = HibernateUtil.getSession();
        Query query = session.createQuery("from Dance where man.id = :id");
        query.setParameter("id",man.getId());
        return query.list();
    }
    public static List getAllHerDances(Woman woman){
        session = HibernateUtil.getSession();
        Query query = session.createQuery("from Dance where woman.id = :id");
        query.setParameter("id",woman.getId());
        return query.list();
    }

}
