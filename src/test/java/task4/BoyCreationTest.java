package task4;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static java.time.Month.JANUARY;
import static java.time.Month.MAY;

@Listeners({Listener.class})
public class BoyCreationTest extends BaseTest {

    private static Boy boyMonth;

    @BeforeClass(groups = {"mood", "money"})
    public static void createBoys() {
        boyMonth = new Boy(JANUARY);
    }

    @Test
    public void getUserMonth() {
        Assert.assertEquals(boyMonth.getBirthdayMonth(), JANUARY, "Month of created user is not equal to the setted month");
    }

    @Parameters({"wealth"})
    @Test(groups = "money", priority = 1)
    public void checkBoyData(double wealth) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(boyTrue.getBirthdayMonth(), MAY, "Month of created user is not equal to the setted month");
        softAssert.assertEquals(boyTrue.getWealth(), wealth, "Wealth of created user is not equal to the setted wealth");
        softAssert.assertEquals(boyTrue.getGirlFriend(), girlTrue, "Girl of created user is not equal to the setted girl");
        softAssert.assertAll();
    }

    @Test(groups = "money", priority = 2)
    public void checkSpendMoney() {
        double spentMoney = boyTrue.getWealth() - 1;
        double expectedWealth = boyTrue.getWealth() - spentMoney;
        boyTrue.spendSomeMoney(spentMoney);
        Assert.assertEquals(boyTrue.getWealth(), expectedWealth, "Spending Boy's wealth doesn't work ");
    }

    @Test(expectedExceptions = RuntimeException.class, groups = "money", priority = 2)
    public void checkSpendMoneyException() {
        double spentMoney = boyTrue.getWealth() + 1;
        boyTrue.spendSomeMoney(spentMoney);
    }
}
