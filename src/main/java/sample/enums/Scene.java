package sample.enums;
//nu este folosit
public enum Scene {
    SAMPLE("D:\\\\SDA\\\\20200302JavaFX\\\\src\\\\main\\\\java\\\\sample\\\\scene\\\\sample.fxml"),
    HOME("D:\\SDA\\20200302JavaFX\\src\\main\\java\\sample\\scene\\home.fxml"),
    REGISTER("D:\\SDA\\20200302JavaFX\\src\\main\\java\\sample\\scene\\register.fxml");

    private String path;

    private Scene(String path) {
        this.path = path;
    }
}
