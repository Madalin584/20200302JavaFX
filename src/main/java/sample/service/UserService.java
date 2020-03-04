package sample.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import sample.model.User;
import sample.service.abstractint.UserInt;
import sample.service.utils.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UserService implements UserInt {
    Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public void create(User user) {
        System.out.println("A ajuns in metoda pentru introducere in DB");
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSession();
            String hql = "from User";
            Query<User> query = session.createQuery(hql, User.class);
            users = query.getResultList();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
