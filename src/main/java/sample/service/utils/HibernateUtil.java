package sample.service.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import org.hibernate.service.ServiceRegistry;
import sample.model.User;

import java.util.Properties;
import java.util.logging.Logger;

/**
 * 1.Configuration parameters
 * 2.SessionFactory
 * 3.Session for CRUD operations
 */
public class HibernateUtil {
    private static Logger logger = Logger.getLogger(HibernateUtil.class.getName());
    //obiectul ce va folosi principiul singleton
    private static SessionFactory sessionFactory;

    //nu se pot crea instante ale clasei
    private HibernateUtil() {

    }

    /**
     * 3.Sesiune pentru CRUD operations
     *
     * @returneaza un obiect de tip Session
     */
    public static Session getSession() {
        logger.info("Este returnata sesiunea de lucru...");
        return getSessionFactory().openSession();
    }

    //singleton
    //2.Session Factory
    private static SessionFactory getSessionFactory() {
        logger.info("Se executa session factory operations...");
        Configuration configuration = getConfiguration();

        if (sessionFactory == null) {
            logger.info("Obiectul de tip sessionFactory are valoarea NULL, va fi creat");
            configuration.addAnnotatedClass(User.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            logger.info("Obiectul sessionFactory este returnat.");
            return sessionFactory;
        }
        logger.info("Se returneaza obiectul sessionFactory");
        return sessionFactory;
    }

    //1.Configuratie
    private static Configuration getConfiguration() {
        logger.info("Se executa setarile pentru configuratie...");
        Configuration configuration = new Configuration();
        Properties properties = new Properties();
        //hashmap<K,V> pentru stocarea valorilor
        properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        properties.put(Environment.URL, "jdbc:mysql://localhost:3306/javafx_schema?useSSL=false");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "root");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        properties.put(Environment.SHOW_SQL, "true");
        properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        //tabelele vor ramane dupa fiecare inchidere a aplicatiei
        properties.put(Environment.HBM2DDL_AUTO, "update");
        configuration.setProperties(properties);
        logger.info("Setarile de configuratie s-au realizat cu succes");
        return configuration;
    }
}
