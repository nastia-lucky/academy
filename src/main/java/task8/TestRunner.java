package task8;

import org.testng.TestNG;

import java.util.Arrays;
import java.util.List;

public class TestRunner {

    public static void main(String[] args) {
        TestNG testNg = new TestNG();
        List<String> files = Arrays.asList(
                "./src/main/resources/testng.xml");
        testNg.setTestSuites(files);
        testNg.run();
    }
}
