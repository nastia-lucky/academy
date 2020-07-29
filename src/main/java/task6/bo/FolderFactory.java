package task6.bo;

public class FolderFactory {

    public static Folder getFolderName() {
        return new Folder().withName("New Test Folder");
    }
}
