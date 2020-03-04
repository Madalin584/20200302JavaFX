package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.model.User;
import sample.service.UserService;
import sample.service.utils.FilePathUtil;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class Controller {
    //enum pentru file paths
    //user controller, care sa apeleze service cu toate operatiile  CRUD
    //User service
    private Logger logger = Logger.getLogger(this.getClass().getName());
    UserService userService = new UserService();
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Button closeButton;

    public void login() {
        if (validate()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("You have logged in succesfully");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("You have failed successfully ! Incorrect username or password.");
            alert.setContentText("If you don't have account please register here ");
            alert.show();
        }
    }

    //changeScene after login
    public void changeScene(ActionEvent event) {
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource(FilePathUtil.getFilePathHomeScene()));
            Scene scene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean validate() {
        List<User> dbUsers = userService.getAll();
        for (User each : dbUsers) {
            if (username.getText().equals(each.getUsername()) && password.getText().equals(each.getPassword())) {
                return true;
            }
        }
        return false;
    }

    @FXML
    private void closeButtonAction() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Controller)) return false;
        Controller that = (Controller) o;
        return username.equals(that.username) &&
                password.equals(that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
