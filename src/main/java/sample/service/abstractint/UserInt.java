package sample.service.abstractint;

import sample.model.User;

import java.util.List;

public interface UserInt {
    //CRUD
    void create();

    List<User> getAll();

    void update();

    void delete();
}
