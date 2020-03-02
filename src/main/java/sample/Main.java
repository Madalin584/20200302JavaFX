package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import sample.model.User;
import sample.service.HibernateUtil;

import java.util.List;

public class Main /*extends Application */ {

//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("scene/sample.fxml"));
//        primaryStage.setTitle("Login");
//        primaryStage.setScene(new Scene(root, 600, 500));
//        primaryStage.show();
//    }


    public static void main(String[] args) {
        //launch(args);
        System.out.println("test");
        getPeople(1);
    }

    public static void getPeople(int id) {
        try {
            Session session = HibernateUtil.getSession();
            String hql = "from User";
            //User user = session.find(User.class, 1);
            Query query = session.createQuery(hql, User.class);
            List resultSet = query.getResultList();

            System.out.println(resultSet.toString());
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }
}
