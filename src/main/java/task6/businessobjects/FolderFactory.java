package task6.businessobjects;

public class FolderFactory {

    public static Folder getFolderName() {
        return new Folder().withName("New Test Folder");
    }
}
