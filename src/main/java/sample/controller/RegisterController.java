package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.model.User;
import sample.service.UserService;

import java.util.List;
import java.util.logging.Logger;

public class RegisterController {
    Logger loggerRegisterClassController = Logger.getLogger(this.getClass().getName());
    private UserService userService;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField email;
    @FXML
    private TextField username;
    @FXML
    private TextField password;

    public RegisterController() {
        this.userService = new UserService();
    }

    public void test() {
        User user = new User(firstName.getText(), lastName.getText(), email.getText(), username.getText(), password.getText());
        if (!usernameExists(username.getText())) {
            userService.create(user);
            loggerRegisterClassController.info("userul a fost creat");
        } else {
            System.out.println("Username already exists");
        }
    }

    private boolean usernameExists(String username) {
        List<User> users = userService.getAll();
        return users.stream().anyMatch(each -> each.getUsername().equals(username));
    }
}
