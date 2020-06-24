package task6.bio;

public class UserFactory {

    public static User getUserWittInvalidEmail() {
        return new User()
                .withEmail("rthjgrtgrh@mail.ru")
                .withPassword("nastusha1213");
    }

    public static User getUserWithValidCreds() {
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
