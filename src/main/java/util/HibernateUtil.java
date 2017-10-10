package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static Session session;
    private static Configuration configuration;

    static {
        configuration = new Configuration()
                .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                .setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
                .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernatetask")
                .setProperty("hibernate.connection.username", "root")
                .setProperty("hibernate.connection.password", "root")
                .setProperty("hibernate.show_sql", "true")
                .setProperty("hibernate.hbm2ddl.auto", "update")
                .addAnnotatedClass(model.Man.class)
                .addAnnotatedClass(model.Woman.class)
                .addAnnotatedClass(model.Dance.class);
    }

    public static Session getSession() {

        SessionFactory factory = configuration.buildSessionFactory();
        session = factory.openSession();
        return session;
    }
}
