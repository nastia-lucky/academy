package task6.businessobjects;

public class UserFactory {
    public static User getUserWithInvalidEmail() {
        return new User()
                .withEmail("rthjgrtgrh@mail.ru")
                .withPassword("nastusha1213");
    }

    public static User getUserWithValidLogin() {
        return new User()
                .withEmail("a.shafalovich91@mail.ru")
                .withPassword("nastusha1213");
    }

    public static User getUserWithInvalidPassword() {
        return new User()
                .withEmail("a.shafalovich91@mail.ru")
                .withPassword("behbfhgbrhb");
    }
}
