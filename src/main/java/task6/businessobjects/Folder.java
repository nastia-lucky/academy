package task6.businessobjects;

public class Folder {

    private String name;

    public String getName() {
        return name;
    }

    public Folder withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Folder{" +
                "name='" + name + '\'' +
                '}';
    }
}
