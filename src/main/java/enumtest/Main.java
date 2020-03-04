package enumtest;

public class Main {
    public static void main(String[] args) {
        Scene.valueOf("HOME");
        System.out.println(Scene.HOME.path);
    }

    public enum Scene {
        SAMPLE("D:\\\\SDA\\\\20200302JavaFX\\\\src\\\\main\\\\java\\\\sample\\\\scene\\\\sample.fxml"),
        HOME("D:\\SDA\\20200302JavaFX\\src\\main\\java\\sample\\scene\\home.fxml"),
        REGISTER("D:\\SDA\\20200302JavaFX\\src\\main\\java\\sample\\scene\\register.fxml");

        private String path;

        private Scene(String path) {
            this.path = path;
        }
    }
}
