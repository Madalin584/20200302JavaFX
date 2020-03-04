package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.enums.MyScene;

import java.io.File;
import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL urlSampleScene = new File(MyScene.REGISTER.getPath()).toURI().toURL();
        Parent root = FXMLLoader.load(urlSampleScene);
        primaryStage.setTitle("Java FX");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }


}
