package sample.service.utils;

public class FilePathUtil {
    private static final String sampleFXMLPath = "D:\\\\SDA\\\\20200302JavaFX\\\\src\\\\main\\\\java\\\\sample\\\\scene\\\\sample.fxml";
    private static final String registerFXMLPath = "D:\\SDA\\20200302JavaFX\\src\\main\\java\\sample\\scene\\register.fxml";
    private static final String homeFXMLPath = "D:\\SDA\\20200302JavaFX\\src\\main\\java\\sample\\scene\\home.fxml";

    private FilePathUtil() {
    }

    public static String getFilePathHomeScene() {
        return homeFXMLPath;
    }

    public static String getFilePathSampleScene() {
        return sampleFXMLPath;
    }

    public static String getFilePathRegisterScene() {
        return registerFXMLPath;
    }
}
