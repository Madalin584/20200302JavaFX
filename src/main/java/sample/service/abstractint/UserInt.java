package sample.service.abstractint;

import sample.model.User;

import java.util.List;

public interface UserInt {
    //CRUD
    void create(User user);

    List<User> getAll();

    void update();

    void delete();
}
