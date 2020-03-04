package sample.enums;

public enum MyScene {
    SAMPLE("D:\\SDA\\20200302JavaFX\\src\\main\\java\\sample\\scene\\sample.fxml"),
    HOME("D:\\SDA\\20200302JavaFX\\src\\main\\java\\sample\\scene\\home.fxml"),
    REGISTER("D:\\SDA\\20200302JavaFX\\src\\main\\java\\sample\\scene\\register.fxml");

    private String path;

    private MyScene(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
