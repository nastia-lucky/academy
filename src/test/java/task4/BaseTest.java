package task4;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import java.time.Month;

@Listeners({Listener.class})
public class BaseTest {

    protected static Girl girlTrue;
    protected static Girl girlFalse;
    protected static Boy boyTrue;

    @Parameters({"wealth"})
    @BeforeClass(groups = {"mood", "money"})
    static void createUsers(double wealth) {
        girlTrue = new Girl(true, true, boyTrue);
        boyTrue = new Boy(Month.MAY, wealth, girlTrue);
        girlFalse = new Girl(false, false);
    }

}
