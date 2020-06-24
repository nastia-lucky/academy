package task6.bio;

public class LetterFactory {
    public static Letter getValidLetter() {
        return new Letter()
                .withAddress("a.shafalovich91@mail.ru")
                .withSubject("Test positive")
                .withText("Test text");
    }

    public static Letter getLetterWithInvalidAddress() {
        return new Letter()
                .withAddress("a.shafalovich91mail.ru")
                .withSubject("Test positive")
                .withText("Test text");
    }

    public static Letter getLetterWithOnlyAddress() {
        return new Letter()
                .withAddress("a.shafalovich91@mail.ru")
                .withSubject("")
                .withText("");
    }

}
