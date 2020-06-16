package task4;

import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Month;

import static java.time.Month.*;

@Listeners({Listener.class})
public class BoyMoodCheck extends BaseTest {

    private static Boy boyExellentMood;
    private static Boy boyGoodMood;
    private static Boy boyNeutralMood;
    private static Boy boyHorribleMood;

    @Parameters({"wealth"})
    @BeforeClass(groups = {"mood", "money"})
    public void createData(double wealth) {
        createUsers(wealth);
    }

    @Parameters({"wealth"})
    @Test(groups = "mood", priority = 2)
    public void checkExellentMoodCheck(double wealth) {
        boyExellentMood = new Boy(Month.JUNE, wealth, girlTrue);
        Assert.assertEquals(boyExellentMood.getMood(), Mood.EXCELLENT);
    }

    @Parameters({"wealth"})
    @Test(groups = "mood", priority = 2)
    public void checkGoodMood(double wealth) {
        boyGoodMood = new Boy(JANUARY, wealth, girlTrue);
        Assert.assertEquals(boyGoodMood.getMood(), Mood.GOOD);
    }

    @Parameters({"wealth"})
    @Test(groups = "mood", priority = 2)
    public void checkNeutralMood(double wealth) {
        boyNeutralMood = new Boy(Month.JUNE, wealth, girlFalse);
        Assert.assertEquals(boyNeutralMood.getMood(), Mood.NEUTRAL);
    }

    @DataProvider(name = "data for bad mood")
    public Object[][] createBoydata() {
        return new Object[][]{
                {DECEMBER, 1_000_000, null},
                {JUNE, 45, null},
                {DECEMBER, 56, girlTrue}
        };
    }

    @Test(dataProvider = "data for bad mood", groups = "mood", priority = 2)
    public void checkBadMood(Month month, double wealth, Girl girl) {
        Boy boyBadMood = new Boy(month, wealth, girl);
        Assert.assertEquals(boyBadMood.getMood(), Mood.BAD);
    }

    @Parameters({"notwealth"})
    @Test(groups = "mood", priority = 2)
    public void checkHorribleMood(double notwealth) {
        boyHorribleMood = new Boy(JANUARY, notwealth, girlFalse);
        Assert.assertEquals(boyHorribleMood.getMood(), Mood.HORRIBLE);
    }


}
